package com.mofang.feedweb.entity;

/**
 * 
 * @author daisyli
 *
 */
public class ModeratorApplyCondition {

	private boolean isPass = false;
	
	private boolean isFollowOk = false;
	
	private boolean isThreadsOk = false;
	
	private boolean isIntervalOk = false;
	
	private boolean isElitecountOk = false;

	public boolean getIsPass() {
		return isPass;
	}

	public void setIsPass(boolean isPass) {
		this.isPass = isPass;
	}

	public boolean getIsFollowOk() {
		return isFollowOk;
	}

	public void setIsFollowOk(boolean isFollowOk) {
		this.isFollowOk = isFollowOk;
	}

	public boolean getIsThreadsOk() {
		return isThreadsOk;
	}

	public void setIsThreadsOk(boolean isThreadsOk) {
		this.isThreadsOk = isThreadsOk;
	}

	public boolean getIsIntervalOk() {
		return isIntervalOk;
	}

	public void setIsIntervalOk(boolean isIntervalOk) {
		this.isIntervalOk = isIntervalOk;
	}

	public boolean getIsElitecountOk() {
		return isElitecountOk;
	}

	public void setIsElitecountOk(boolean isElitecountOk) {
		this.isElitecountOk = isElitecountOk;
	}
	
}
