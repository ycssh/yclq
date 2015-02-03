package cn.yc.ssh.cq.base.service;

import java.util.List;
import java.util.Set;

import cn.yc.ssh.cq.base.entity.BaseConditionVO;
import cn.yc.ssh.cq.base.entity.User;
import cn.yc.ssh.cq.base.exception.ServiceException;

/**
 * <p>
 * User: yc
 */
public interface UserService {

	/**
	 * 创建用户
	 * 
	 * @param user
	 */
	public User createUser(User user) throws ServiceException;

	public User updateUser(User user);

	public void deleteUser(Long userId);

	/**
	 * 修改密码
	 * 
	 * @param userId
	 * @param newPassword
	 */
	public void changePassword(Long userId, String newPassword)
			throws ServiceException;

	User findOne(Long userId);

	/**
	 * 根据用户名查找用户
	 * 
	 * @param username
	 * @return
	 */
	public User findByUsername(String username);

	/**
	 * 根据用户名查找其角色
	 * 
	 * @param username
	 * @return
	 */
	public Set<String> findRoles(String username);

	/**
	 * 根据用户名查找其权限
	 * 
	 * @param username
	 * @return
	 */
	public Set<String> findPermissions(String username);

	List<User> searchUser(BaseConditionVO vo);

	Integer searchUserNum(BaseConditionVO vo);

	void saveUserRole(Long[] roles, Long userId);
}
