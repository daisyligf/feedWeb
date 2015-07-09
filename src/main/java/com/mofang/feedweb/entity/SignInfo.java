package com.mofang.feedweb.entity;

public class SignInfo {
	private boolean is_sign_in;
	private int days;
	private int rank;
	private int totalMember;
	
	public boolean isIs_sign_in() {
		return is_sign_in;
	}
	public void setIs_sign_in(boolean is_sign_in) {
		this.is_sign_in = is_sign_in;
	}
	public int getDays() {
		return days;
	}
	public void setDays(int days) {
		this.days = days;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	public int getTotalMember() {
		return totalMember;
	}
	public void setTotalMember(int totalMember) {
		this.totalMember = totalMember;
	}
	
	
}
