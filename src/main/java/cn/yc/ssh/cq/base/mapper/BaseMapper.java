package cn.yc.ssh.cq.base.mapper;

import java.util.List;

public interface BaseMapper<T, PK extends java.io.Serializable> {

	Long insert(T model);

	void delete(PK modelPK);
	
	T load(PK modelPK);
	
	void update(T model);

	void updateSelective(T model);
	
	int countAll();
	
	List<T> findAll();
	
	List<PK> findAllIds();
	
}