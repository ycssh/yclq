package cn.yc.ssh.cq.base.service;

import cn.yc.ssh.cq.base.entity.Resources;

import java.util.List;
import java.util.Set;

/**
 * <p>User: yc
 */
public interface ResourceService {


    public Resources createResource(Resources resource);
    public Resources updateResource(Resources resource);
    public void deleteResource(Long resourceId);

    Resources findOne(Long resourceId);
    List<Resources> findAll();

    /**
     * 得到资源对应的权限字符串
     * @param resourceIds
     * @return
     */
    Set<String> findPermissions(Set<Long> resourceIds);

    /**
     * 根据用户权限得到菜单
     * @param permissions
     * @return
     */
    List<Resources> findMenus(Set<String> permissions);
}
