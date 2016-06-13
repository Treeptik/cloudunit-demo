package fr.treeptik.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.treeptik.base.model.RandomStock;
import fr.treeptik.base.model.Stock;

@Controller
public class WebSocketController {

	@Autowired
	private SimpMessagingTemplate simpMessagingTemplate;

	public void refresh() {
		Stock stock = RandomStock.aleajactaest();
		simpMessagingTemplate.convertAndSend("/topic/results", stock);
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
