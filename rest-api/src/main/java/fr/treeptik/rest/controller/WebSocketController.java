package fr.treeptik.rest.controller;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.treeptik.base.model.Company;

@Controller
public class WebSocketController {

	@Autowired
	private SimpMessagingTemplate simpMessagingTemplate;

	public void refresh() {
		Company company = new Company(1L, "IBM", new Random().nextDouble(), new Random().nextDouble(),
				new Random().nextInt(), new Random().nextDouble());
		simpMessagingTemplate.convertAndSend("/topic/results", company);
	}

	@RequestMapping("/")
	public String start() {
		return "index";
	}

	@Scheduled(fixedDelay = 2000)
	public void schedule() throws Exception {
		refresh();
	}

}
