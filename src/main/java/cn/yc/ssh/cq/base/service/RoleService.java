package cn.yc.ssh.cq.base.service;

import java.util.List;
import java.util.Set;

import cn.yc.ssh.cq.base.entity.BaseConditionVO;
import cn.yc.ssh.cq.base.entity.Resources;
import cn.yc.ssh.cq.base.entity.Role;
import cn.yc.ssh.cq.base.exception.ServiceException;

/**
 * <p>User: yc
 */
public interface RoleService {


    public Role createRole(Role role) throws ServiceException;
    
    public Role updateRole(Role role);
    
    public void deleteRole(Long roleId);

    public Role findOne(Long roleId);
    
    public List<Role> findAll();
    
    List<Role> findByUser(Long userId);

    /**
     * 根据角色编号得到角色标识符列表
     * @param roleIds
     * @return
     */
    Set<String> findRoles(Long... roleIds);

    /**
     * 根据角色编号得到权限字符串列表
     * @param roleIds
     * @return
     */
    Set<String> findPermissions(Long[] roleIds);
    
	List<Role> searchRole(BaseConditionVO vo);

	Integer searchUserNum(BaseConditionVO vo);
	
	void saveRoleRes(Long[] res, Long roleId);

	public List<Resources> queryResources(Long id);
}
