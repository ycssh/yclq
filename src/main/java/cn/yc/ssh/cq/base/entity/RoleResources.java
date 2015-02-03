package cn.yc.ssh.cq.base.entity;

import java.io.Serializable;

public class RoleResources implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5584841280188670594L;
	private Long id;
	private Long roleId;
	private Long resId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public Long getResId() {
		return resId;
	}

	public void setResId(Long resId) {
		this.resId = resId;
	}

}
