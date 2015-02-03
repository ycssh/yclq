package cn.yc.ssh.cq.base.enums;

public enum Active {
	active("启用"), inactive("禁用");

	private String name;

	private Active(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
