package cn.yc.ssh.cq.base.dao;

import cn.yc.ssh.cq.base.entity.Resources;

import java.util.List;

/**
 * <p>Resource: yc
 * <p>Date: 14-1-28
 * <p>Version: 1.0
 */
public interface ResourceDao {

    public Resources createResource(Resources resource);
    public Resources updateResource(Resources resource);
    public void deleteResource(Long resourceId);

    Resources findOne(Long resourceId);
    List<Resources> findAll();

}
