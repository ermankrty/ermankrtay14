package com.ermankurtay.assignment14.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.ermankurtay.assignment14.domain.Message;

@Component
public class MessageRepository {
	
	public Map<Long, List<Message>> messages = new HashMap<>();
	
	public Optional<List<Message>> getMessages(Long channelId){
		List<Message> channelMessages = messages.get(channelId);
		return Optional.ofNullable(channelMessages);
	}
	public void saveMessages(Long channelId, List<Message> channelMessages) {
		messages.put(channelId, channelMessages);
	}

}
