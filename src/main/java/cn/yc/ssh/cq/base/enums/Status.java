package cn.yc.ssh.cq.base.enums;

public enum Status {
	NORMAL("启用"), DISABLE("禁用"), DELETE("删除");

	private String name;

	private Status(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
