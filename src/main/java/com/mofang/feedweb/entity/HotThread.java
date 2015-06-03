package com.mofang.feedweb.entity;

/**
 * 
 * @author daisyli
 * 热帖
 *
 */
public class HotThread {

	private long threadId;
	
	private String subject;

	public HotThread() {
		super();
	}
	
	public HotThread(long threadId, String subject) {
		super();
		this.threadId = threadId;
		this.subject = subject;
	}

	public long getThreadId() {
		return threadId;
	}

	public void setThreadId(long threadId) {
		this.threadId = threadId;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}
	
}
