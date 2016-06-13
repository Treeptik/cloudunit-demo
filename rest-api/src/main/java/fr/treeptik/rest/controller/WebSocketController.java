package fr.treeptik.rest.controller;

import java.util.Random;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.treeptik.base.model.Company;

@Controller
public class WebSocketController {

	@MessageMapping("/add")
	@SendTo("/topic/showResult")
	public Company addNum() throws Exception {
		Thread.sleep(2000);
		Company company = new Company(1L, "IBM", new Random().nextDouble(), new Random().nextDouble(),
				new Random().nextInt(), new Random().nextDouble());
		return company;
	}

	@RequestMapping("/")
	public String start() {
		return "index";
	}

	@Scheduled(fixedDelay = 2000)
	public void schedule() throws Exception {
		System.out.println("appel schedule");
		addNum();
	}

}
