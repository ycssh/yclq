package cn.yc.ssh.cq.base.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.shiro.authz.permission.WildcardPermission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import cn.yc.ssh.cq.base.entity.Resources;
import cn.yc.ssh.cq.base.mapper.ResourcesMapper;

/**
 * <p>User: yc
 */
@Service

public class ResourceServiceImpl implements ResourceService {

    @Autowired
    private ResourcesMapper resourcesMapper;

    @Override
    public Resources createResource(Resources resource) {
         Long id = resourcesMapper.insert(resource);
         resource.setId(id);
         return resource;
    }

    @Override
    public Resources updateResource(Resources resource) {
        resourcesMapper.updateSelective(resource);
        return resource;
    }

    @Override
    public void deleteResource(Long resourceId) {
        resourcesMapper.delete(resourceId);
    }

    @Override
    public Resources findOne(Long resourceId) {
        return resourcesMapper.load(resourceId);
    }

    @Override
    public List<Resources> findAll() {
        return resourcesMapper.findAll();
    }

    @Override
    public Set<String> findPermissions(Set<Long> resourceIds) {
        Set<String> permissions = new HashSet<String>();
        for(Long resourceId : resourceIds) {
            Resources resource = findOne(resourceId);
            if(resource != null && !StringUtils.isEmpty(resource.getPermission())) {
                permissions.add(resource.getPermission());
            }
        }
        return permissions;
    }

    @Override
    public List<Resources> findMenus(Set<String> permissions) {
        List<Resources> allResources = findAll();
        List<Resources> menus = new ArrayList<Resources>();
        for(Resources resource : allResources) {
            if(resource.getId()==0) {
                continue;
            }
            if(resource.getType() != Resources.ResourceType.menu) {
                continue;
            }
            if(!hasPermission(permissions, resource)) {
                continue;
            }
            menus.add(resource);
        }
        return menus;
    }

    private boolean hasPermission(Set<String> permissions, Resources resource) {
        if(StringUtils.isEmpty(resource.getPermission())) {
            return true;
        }
        for(String permission : permissions) {
            WildcardPermission p1 = new WildcardPermission(permission);
            WildcardPermission p2 = new WildcardPermission(resource.getPermission());
            if(p1.implies(p2) || p2.implies(p1)) {
                return true;
            }
        }
        return false;
    }
}
