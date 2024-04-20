package com.ermankurtay.assignment14.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ermankurtay.assignment14.domain.Channel;
import com.ermankurtay.assignment14.domain.Message;
import com.ermankurtay.assignment14.repository.ChannelRepository;
import com.ermankurtay.assignment14.repository.MessageRepository;

@Service
public class MessageService {

	@Autowired
	private MessageRepository messageRepo;
	@Autowired
	private ChannelRepository channelRepo;
	
	public List<Message> getMessages(Long channelId){
		return messageRepo.getMessages(channelId).orElse(new ArrayList<>());
	}
	
	public void saveMessage(Message message) {
		Long channelId = message.getChannelId();
		Optional<Channel> optionalChannel = Optional.ofNullable(channelRepo.findByChannelId(channelId));
		if(optionalChannel.isPresent()) {
			List<Message> channelMessages = getMessages(channelId);
			channelMessages.add(message);
			messageRepo.saveMessages(channelId, channelMessages);
		}
	}
}
