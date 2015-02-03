package cn.yc.ssh.cq.base.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.yc.ssh.cq.base.entity.BaseConditionVO;
import cn.yc.ssh.cq.base.entity.User;
import cn.yc.ssh.cq.base.entity.UserRole;
import cn.yc.ssh.cq.base.exception.ServiceException;
import cn.yc.ssh.cq.base.mapper.UserMapper;

/**
 * <p>
 * User: yc
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private PasswordHelper passwordHelper;
	@Autowired
	private RoleService roleService;
	@Autowired
	private UserMapper userMapper;

	/**
	 * 创建用户
	 * 
	 * @param user
	 */
	public User createUser(User user) throws ServiceException {
		if (userMapper.isUniqueUsername(user) != 0) {
			throw new ServiceException("该用户名已存在");
		}
		// 加密密码
		passwordHelper.encryptPassword(user);
		user.setStatus("NORMAL");
		Long id = userMapper.insert(user);
		user.setId(id);
		return user;
	}

	@Override
	public User updateUser(User user) {
		userMapper.updateSelective(user);
		return user;
	}

	@Override
	public void deleteUser(Long userId) {
		userMapper.delete(userId);
	}

	/**
	 * 修改密码
	 * 
	 * @param userId
	 * @param newPassword
	 */
	public void changePassword(Long userId, String newPassword)
			throws ServiceException {
		User user = userMapper.load(userId);
		user.setPassword(newPassword);
		passwordHelper.encryptPassword(user);
		userMapper.updateSelective(user);
	}

	@Override
	public User findOne(Long userId) {
		return userMapper.load(userId);
	}

	/**
	 * 根据用户名查找用户
	 * 
	 * @param username
	 * @return
	 */
	public User findByUsername(String username) {
		return userMapper.findByUsername(username);
	}

	/**
	 * 根据用户名查找其角色
	 * 
	 * @param username
	 * @return
	 */
	public Set<String> findRoles(String username) {
		User user = findByUsername(username);
		if (user == null) {
			return Collections.emptySet();
		}
		return roleService.findRoles(user.getRoleIds().toArray(new Long[0]));
	}

	/**
	 * 根据用户名查找其权限
	 * 
	 * @param username
	 * @return
	 */
	public Set<String> findPermissions(String username) {
		User user = findByUsername(username);
		if (user == null) {
			return Collections.emptySet();
		}
		return roleService.findPermissions(user.getRoleIds().toArray(
				new Long[0]));
	}

	@Override
	public List<User> searchUser(BaseConditionVO vo) {
		RowBounds rb = new RowBounds(vo.getStartIndex(), vo.getPageSize());
		return userMapper.findPageBreakByCondition(vo, rb);
	}

	public Integer searchUserNum(BaseConditionVO vo) {
		Integer count = userMapper.findNumberByCondition(vo);
		return count;
	}

	@Override
	public void saveUserRole(Long[] roles, Long userId) {
		userMapper.deleteUserRole(userId);
		List<UserRole> list = new ArrayList<UserRole>();
		for (Long role : roles) {
			UserRole userRole = new UserRole();
			userRole.setRoleId(role);
			userRole.setUserId(userId);
			list.add(userRole);
		}
		userMapper.insertUserRole(list);
	}
}
