package fr.treeptik.data.generator.service;

import fr.treeptik.base.model.Company;

public interface CompanyMessageService {

	Company generateRandomCompany();

	void sendMessage();

}
