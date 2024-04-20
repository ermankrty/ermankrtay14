package com.ermankurtay.assignment14.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ermankurtay.assignment14.domain.Channel;
import com.ermankurtay.assignment14.repository.ChannelRepository;

@Service
public class ChannelService {

	@Autowired
	private ChannelRepository channelRepo;
	
	
	
	public List<Channel> findAll(){
		List<Channel> channels = channelRepo.findAll();
		return channels;
	}
	
	public Channel findByChannelId(Long channelId) {
		return channelRepo.findByChannelId(channelId);
		
	}
	
	public Channel saveChannel(String channelName) {
		return channelRepo.save(channelName);
	}

}
