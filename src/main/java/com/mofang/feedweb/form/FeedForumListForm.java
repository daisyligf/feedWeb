package com.mofang.feedweb.form;

import java.util.List;

import com.mofang.feedweb.entity.ForumListInfo;

public class FeedForumListForm {

	private int total;
	private List<ForumListInfo> infoList;
	
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public List<ForumListInfo> getInfoList() {
		return infoList;
	}
	public void setInfoList(List<ForumListInfo> infoList) {
		this.infoList = infoList;
	}

	
	
	
}
