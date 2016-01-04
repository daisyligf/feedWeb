package com.mofang.feedweb.entity;

import java.util.Date;
import java.util.List;

/**
 * @author ke
 *
 */
public class FeedPost {
	
	private long post_id;
	private String post_name;
	private int position;
	private int comments;
	private int replies;
	private int recommends;
	private boolean isRecommend;
	private Date create_time;
	private Date update_time;
	private String format;
	private int status;
	private long user_id;
	private boolean currentUserFlg = false;
	private String user_name;
	private long forum_id;
	private long thread_id;
	private String content;
	private String htmlContent;
	private UserInfo postUserInfo;
	private List<FeedComment> commentList;
	private List<String> pic;
	private boolean lastPositionFlg = false;
	
	public long getPost_id() {
		return post_id;
	}
	public void setPost_id(long post_id) {
		this.post_id = post_id;
	}
	public String getPost_name() {
		return post_name;
	}
	public void setPost_name(String post_name) {
		this.post_name = post_name;
	}
	public int getPosition() {
		return position;
	}
	public void setPosition(int position) {
		this.position = position;
	}
	public int getComments() {
		return comments;
	}
	public void setComments(int comments) {
		this.comments = comments;
	}
	public int getRecommends() {
		return recommends;
	}
	public void setRecommends(int recommends) {
		this.recommends = recommends;
	}
	public boolean getIsRecommend() {
		return isRecommend;
	}
	public void setIsRecommend(boolean isRecommend) {
		this.isRecommend = isRecommend;
	}
	public Date getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}
	
	public String getFormat() {
		return format;
	}
	public void setFormat(String format) {
		this.format = format;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public long getUser_id() {
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
	public long getForum_id() {
		return forum_id;
	}
	public void setForum_id(long forum_id) {
		this.forum_id = forum_id;
	}
	public long getThread_id() {
		return thread_id;
	}
	public void setThread_id(long thread_id) {
		this.thread_id = thread_id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	public String getHtmlContent() {
		return htmlContent;
	}
	public void setHtmlContent(String htmlContent) {
		this.htmlContent = htmlContent;
	}
	public int getReplies() {
		return replies;
	}
	public void setReplies(int replies) {
		this.replies = replies;
	}
	
	public UserInfo getPostUserInfo() {
		return postUserInfo;
	}
	public void setPostUserInfo(UserInfo postUserInfo) {
		this.postUserInfo = postUserInfo;
	}
	public List<FeedComment> getCommentList() {
		return commentList;
	}
	public void setCommentList(List<FeedComment> commentList) {
		this.commentList = commentList;
	}
	public List<String> getPic() {
		return pic;
	}
	public void setPic(List<String> pic) {
		this.pic = pic;
	}
	public boolean isCurrentUserFlg() {
		return currentUserFlg;
	}
	public void setCurrentUserFlg(boolean currentUserFlg) {
		this.currentUserFlg = currentUserFlg;
	}
	public boolean isLastPositionFlg() {
		return lastPositionFlg;
	}
	public void setLastPositionFlg(boolean lastPositionFlg) {
		this.lastPositionFlg = lastPositionFlg;
	}
	public Date getUpdate_time() {
		return update_time;
	}
	public void setUpdate_time(Date update_time) {
		this.update_time = update_time;
	}
	
}
