package cn.yc.ssh.cq.base.dao;

import java.util.List;

import cn.yc.ssh.cq.base.entity.Role;

/**
 * <p>User: yc
 * <p>Date: 14-1-28
 * <p>Version: 1.0
 */
public interface RoleDao {

    public Role createRole(Role role);
    public Role updateRole(Role role);
    public void deleteRole(Long roleId);

    public Role findOne(Long roleId);
    public List<Role> findAll();
}
