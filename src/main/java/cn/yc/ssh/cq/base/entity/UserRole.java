package cn.yc.ssh.cq.base.entity;

import java.io.Serializable;

public class UserRole implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8710721280594862982L;
	private Long id;
	private Long userId;
	private Long roleId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

}
