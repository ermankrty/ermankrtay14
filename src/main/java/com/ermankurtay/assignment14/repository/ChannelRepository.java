package com.ermankurtay.assignment14.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.ermankurtay.assignment14.domain.Channel;

@Component
public class ChannelRepository {

	private List<Channel> channels = new ArrayList<>();
	

	public List<Channel> findAll() {
		return channels;
	}

	

	public Channel findByChannelId(Long channelId) {
		Optional<Channel> foundChannel = channels.stream().filter(channel -> channel.getChannelId().equals(channelId)).findAny();
		return foundChannel.orElse(new Channel());
	}



	public Channel save(String channelName) {
		Channel channel = new Channel();
		channel.setName(channelName);
		channels.add(channel);
		channel.setChannelId((long) channels.size());
		return channel;
	}
	
	public ChannelRepository() {
		Channel generalChannel = new Channel();
		generalChannel.setName("DEFAULT");
		generalChannel.setChannelId((long) 1);
		channels.add(generalChannel);
	}






}
