package cn.yc.ssh.cq.base.enums;

public enum ResourceType {
	menu("男"), button("女");

	private String name;

	private ResourceType(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
