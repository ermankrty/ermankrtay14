package com.ermankurtay.assignment14.domain;


public class Channel {
	
	private Long channelId;
	private String name;
	
	public Long getChannelId() {
		return channelId;
	}
	public void setChannelId(Long channelId) {
		this.channelId = channelId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Channel [CId=" + channelId + ", name=" + name + "]";
	}
	
	

}
