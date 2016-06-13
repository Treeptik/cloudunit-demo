package fr.treeptik.data.generator.service;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import fr.treeptik.base.model.Company;

@Service
public class CompanyMessageServiceImpl implements CompanyMessageService {

	public String[] companiesNames = { "IBM", "Oracle", "Docker", "Treeptik", "Xebia" };

	@Autowired
	private JmsTemplate jmsTemplate;

	@Override
	public Company generateRandomCompany() {
		Company company = new Company();
		company.setChange(new Random().nextDouble());
		company.setName(companiesNames[new Random().nextInt(5)]);
		company.setPrice(new Random().nextDouble());
		company.setValue(new Random().nextDouble());
		company.setShare(new Random().nextInt());
		return company;
	}

	@Override
	@Scheduled(fixedDelay = 3000)
	public void sendMessage() {
		System.out.println("populate");
		jmsTemplate.convertAndSend(generateRandomCompany());
	}

}
