package cn.yc.ssh.cq.base.service;

import cn.yc.ssh.cq.base.entity.Organization;

import java.util.List;

/**
 * <p>User: yc
 */
public interface OrganizationService {


    public Organization createOrganization(Organization organization);
    public Organization updateOrganization(Organization organization);
    public void deleteOrganization(Long organizationId);

    Organization findOne(Long organizationId);
    List<Organization> findAll();

    Object findAllWithExclude(Organization excludeOraganization);

    void move(Organization source, Organization target);
}
