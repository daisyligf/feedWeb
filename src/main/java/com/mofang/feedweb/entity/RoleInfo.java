package com.mofang.feedweb.entity;

/**
 * 
 * @author daisyli
 * 吧主
 *
 */
public class RoleInfo {
	
	private long roleId;
	
	private String roleName;
	
	private String icon;
	
	public RoleInfo() {
		super();
	}

	public RoleInfo(long roleId, String roleName, String icon) {
		super();
		this.roleId = roleId;
		this.roleName = roleName;
		this.icon = icon;
	}

	public long getRoleId() {
		return roleId;
	}

	public void setRoleId(long roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}
	

}
