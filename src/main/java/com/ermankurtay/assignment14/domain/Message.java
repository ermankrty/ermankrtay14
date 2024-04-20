package com.ermankurtay.assignment14.domain;

public class Message {
	
	private String text;
	private User user;
	private Long channelId;
	
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public long getChannelId() {
		return channelId;
	}
	public void setChannelId(Long channelId) {
		this.channelId = channelId;
	}
	@Override
	public String toString() {
		return "Message [text=" + text + ", user=" + user + ", channelId=" + channelId + "]";
	}
	
	

}
