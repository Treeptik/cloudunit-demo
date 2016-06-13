package fr.treeptik.data.generator.service;

import fr.treeptik.base.model.PersistentStock;

public interface CompanyMessageService {

	PersistentStock generateRandomCompany();

	void sendMessage();

}
