package cn.yc.ssh.cq.base.mapper;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

import cn.yc.ssh.cq.base.entity.BaseConditionVO;
import cn.yc.ssh.cq.base.entity.Resources;

@Repository
public interface ResourcesMapper extends BaseMapper<Resources, Long> {
	// 查询
	List<Resources> findPageBreakByCondition(BaseConditionVO vo, RowBounds rb);

	Integer findNumberByCondition(BaseConditionVO vo);

	List<Resources> findByRole(Long roleId);
	
}
