package cn.yc.ssh.cq.base.mapper;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

import cn.yc.ssh.cq.base.entity.BaseConditionVO;
import cn.yc.ssh.cq.base.entity.User;
import cn.yc.ssh.cq.base.entity.UserRole;

@Repository
public interface UserMapper extends BaseMapper<User, Long> {
	// 查询
	List<User> findPageBreakByCondition(BaseConditionVO vo, RowBounds rb);

	Integer findNumberByCondition(BaseConditionVO vo);

	User findByUsername(String username);
	
	Integer isUniqueUsername(User user);

	void deleteUserRole(Long userId);

	void insertUserRole(List<UserRole> list);
}
