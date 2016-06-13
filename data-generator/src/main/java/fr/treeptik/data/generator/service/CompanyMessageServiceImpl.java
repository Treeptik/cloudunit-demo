package fr.treeptik.data.generator.service;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import fr.treeptik.base.model.PersistentStock;

@Service
public class CompanyMessageServiceImpl implements CompanyMessageService {

	private Logger logger = LoggerFactory.getLogger(CompanyMessageService.class);

	public String[] companiesNames = { "IBM", "Oracle", "Docker", "Treeptik", "Xebia" };

	@Autowired
	private JmsTemplate jmsTemplate;

	@Override
	public PersistentStock generateRandomCompany() {
		PersistentStock stock = new PersistentStock();
		stock.setChange(new Random().nextDouble());
		stock.setName(companiesNames[new Random().nextInt(5)]);
		stock.setPrice(new Random().nextDouble());
		stock.setValue(new Random().nextDouble());
		stock.setShare(new Random().nextInt());
		return stock;
	}

	@Override
	@Scheduled(fixedDelay = 3000)
	public void sendMessage() {
		logger.debug("Send new message");
		jmsTemplate.convertAndSend(generateRandomCompany());
	}

}
