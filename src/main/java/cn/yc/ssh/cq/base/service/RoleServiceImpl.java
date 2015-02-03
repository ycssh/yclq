package cn.yc.ssh.cq.base.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.yc.ssh.cq.base.entity.BaseConditionVO;
import cn.yc.ssh.cq.base.entity.Resources;
import cn.yc.ssh.cq.base.entity.Role;
import cn.yc.ssh.cq.base.entity.RoleResources;
import cn.yc.ssh.cq.base.mapper.ResourcesMapper;
import cn.yc.ssh.cq.base.mapper.RoleMapper;

/**
 * <p>User: yc
 */
@Service

public class RoleServiceImpl implements RoleService {

	@Autowired
    private ResourceService resourceService;
	
	@Autowired
	private ResourcesMapper resourcesMapper;
    
    @Resource
    private RoleMapper roleMapper;

    public Role createRole(Role role) {
    	role.setAvailable(Boolean.TRUE);
        Long id = roleMapper.insert(role);
        role.setId(id);
        return role;
    }

    public Role updateRole(Role role) {
        roleMapper.updateSelective(role);
        return role;
    }

    public void deleteRole(Long roleId) {
    	roleMapper.delete(roleId);
    }

    @Override
    public Role findOne(Long roleId) {
        return roleMapper.load(roleId);
    }

    @Override
    public List<Role> findAll() {
        return roleMapper.findAll();
    }

    @Override
    public Set<String> findRoles(Long... roleIds) {
        Set<String> roles = new HashSet<String>();
        for(Long roleId : roleIds) {
            Role role = findOne(roleId);
            if(role != null) {
                roles.add(role.getRole());
            }
        }
        return roles;
    }

    @Override
    public Set<String> findPermissions(Long[] roleIds) {
        Set<Long> resourceIds = new HashSet<Long>();
        for(Long roleId : roleIds) {
            Role role = findOne(roleId);
            if(role != null) {
                resourceIds.addAll(role.getResourceIds());
            }
        }
        return resourceService.findPermissions(resourceIds);
    }

	@Override
	public List<Role> findByUser(Long userId) {
		return roleMapper.findByUser(userId);
	}

	@Override
	public List<Role> searchRole(BaseConditionVO vo) {
		RowBounds rb = new RowBounds(vo.getStartIndex(), vo.getPageSize());
		return roleMapper.findPageBreakByCondition(vo, rb);
	}

	@Override
	public Integer searchUserNum(BaseConditionVO vo) {
		Integer count = roleMapper.findNumberByCondition(vo);
		return count;
	}

	@Override
	public void saveRoleRes(Long[] ress, Long roleId){
		roleMapper.deleteRoleRes(roleId);
		Set<Long> set = new HashSet<Long>();
		set.addAll(Arrays.asList(ress));
		List<RoleResources> list = new ArrayList<RoleResources>();
		for (Long res : set) {
			RoleResources roleResources = new RoleResources();
			roleResources.setRoleId(roleId);
			roleResources.setResId(res);
			list.add(roleResources);
		}
		roleMapper.insertRoleRes(list);
	}

	@Override
	public List<Resources> queryResources(Long id) {
		return resourcesMapper.findByRole(id);
	}
}
