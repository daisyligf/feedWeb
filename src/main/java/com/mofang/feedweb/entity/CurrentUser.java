package com.mofang.feedweb.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author daisyli
 *
 */
public class CurrentUser {
	private boolean isModerator = false;
	
	private boolean isAdmin = false;
	
	private List<Integer> privileges = new ArrayList<Integer>();

	public boolean getIsModerator() {
		return isModerator;
	}

	public void setIsModerator(boolean isModerator) {
		this.isModerator = isModerator;
	}

	public boolean getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public List<Integer> getPrivileges() {
		return privileges;
	}

	public void setPrivileges(List<Integer> privileges) {
		this.privileges = privileges;
	}
	
	
	
}
