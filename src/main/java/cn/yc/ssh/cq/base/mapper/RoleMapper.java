package cn.yc.ssh.cq.base.mapper;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

import cn.yc.ssh.cq.base.entity.BaseConditionVO;
import cn.yc.ssh.cq.base.entity.Role;
import cn.yc.ssh.cq.base.entity.RoleResources;

@Repository
public interface RoleMapper extends BaseMapper<Role, Long> {
	// 查询
	List<Role> findPageBreakByCondition(BaseConditionVO vo, RowBounds rb);

	Integer findNumberByCondition(BaseConditionVO vo);

	List<Role> findByUser(Long userId);
	
	int isUniqueRole(Role role);

	void deleteRoleRes(Long roleId);

	void insertRoleRes(List<RoleResources> list);
	
}
