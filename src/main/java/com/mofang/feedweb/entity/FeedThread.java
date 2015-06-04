package com.mofang.feedweb.entity;

import java.util.Date;
import java.util.List;

/**
 * @author ke
 * 
 */
public class FeedThread {

	private long thread_id;
	private String subject;
	private String htmlContent;
	private String icon;
	private int page_view;
	private int replies;
	private Date create_time;
	private int shareTimes;
	private boolean isClosed;
	private boolean isElite;
	private boolean isTop;
	private boolean isModerator;
	private boolean hasPic;
	private String last_post_time;
	private int recommends;
	private int status;
	private long user_id;
	private String user_name;
	private String avatar;

	private long forum_id;
	private String forum_name;
	private String pic;
	private String content;
	private int tagId;
	
	public int getTagId() {
		return tagId;
	}

	public void setTagId(int tagId) {
		this.tagId = tagId;
	}

	public long getThread_id() {
		return thread_id;
	}

	public void setThread_id(long thread_id) {
		this.thread_id = thread_id;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public int getPage_view() {
		return page_view;
	}

	public void setPage_view(int page_view) {
		this.page_view = page_view;
	}

	public int getReplies() {
		return replies;
	}

	public void setReplies(int replies) {
		this.replies = replies;
	}

	public Date getCreate_time() {
		return create_time;
	}

	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}

	public int getShareTimes() {
		return shareTimes;
	}

	public void setShareTimes(int shareTimes) {
		this.shareTimes = shareTimes;
	}

	public boolean getIsClosed() {
		return isClosed;
	}

	public void setIsClosed(boolean isClosed) {
		this.isClosed = isClosed;
	}

	public String getLast_post_time() {
		return last_post_time;
	}

	public void setLast_post_time(String last_post_time) {
		this.last_post_time = last_post_time;
	}

	public int getRecommends() {
		return recommends;
	}

	public void setRecommends(int recommends) {
		this.recommends = recommends;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public boolean getIsElite() {
		return isElite;
	}

	public void setIsElite(boolean isElite) {
		this.isElite = isElite;
	}

	public boolean getIsTop() {
		return isTop;
	}

	public void setIsTop(boolean isTop) {
		this.isTop = isTop;
	}

	public boolean getIsModerator() {
		return isModerator;
	}

	public void setIsModerator(boolean isModerator) {
		this.isModerator = isModerator;
	}
	public boolean isHasPic() {
		return hasPic;
	}
	public void setHasPic(boolean hasPic) {
		this.hasPic = hasPic;
	}	public long getUser_id() {
		return user_id;
	}

	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public long getForum_id() {
		return forum_id;
	}

	public void setForum_id(long forum_id) {
		this.forum_id = forum_id;
	}

	public String getForum_name() {
		return forum_name;
	}

	public void setForum_name(String forum_name) {
		this.forum_name = forum_name;
	}

	public String getHtmlContent() {
		return htmlContent;
	}

	public void setHtmlContent(String htmlContent) {
		this.htmlContent = htmlContent;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
