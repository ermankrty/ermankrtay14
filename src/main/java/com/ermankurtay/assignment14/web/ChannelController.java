package com.ermankurtay.assignment14.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ermankurtay.assignment14.domain.Channel;
import com.ermankurtay.assignment14.domain.Message;
import com.ermankurtay.assignment14.service.ChannelService;
import com.ermankurtay.assignment14.service.MessageService;

@Controller
public class ChannelController {
	
	@Autowired
	private ChannelService channelService;
	@Autowired
	private MessageService messageService;
	
	
	@GetMapping("/welcome")
	public String getWelcome(ModelMap model) {
		List<Channel> channels = channelService.findAll();
		model.put("channels", channels);
		return "welcome";
	}
	@PostMapping("/create-channel")
	public String newChannel (@RequestParam String channelName) {
		channelService.saveChannel(channelName);
		return "redirect:/";
	}
	@GetMapping("/channels/{channelId}")
	public String getChannel(ModelMap model, @PathVariable Long channelId) {
		Channel channel = channelService.findByChannelId(channelId);
		List<Message> messages = messageService.getMessages(channelId);
		model.put("messages", messages);
		model.put("channel", channel);
		return "channel";
	}
	@GetMapping("/")
	public String welcomeRedirect() {
		return "redirect:/welcome";
	}

}
