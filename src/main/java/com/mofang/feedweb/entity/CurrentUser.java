package com.mofang.feedweb.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @author daisyli
 *
 */
public class CurrentUser {
	private boolean isModerator = false;
	
	private boolean isAdmin = false;
	
	private long currentUserId = 0;
	
	private Set<Integer> privileges = new HashSet<Integer>();

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

	public Set<Integer> getPrivileges() {
		return privileges;
	}

	public void setPrivileges(Set<Integer> privileges) {
		this.privileges = privileges;
	}

	public long getCurrentUserId() {
		return currentUserId;
	}

	public void setCurrentUserId(long currentUserId) {
		this.currentUserId = currentUserId;
	}
	
	
	
}
