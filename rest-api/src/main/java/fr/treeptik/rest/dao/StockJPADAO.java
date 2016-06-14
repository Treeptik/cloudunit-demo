package fr.treeptik.rest.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import fr.treeptik.base.model.PersistentStock;

@Profile("jboss")
@Repository
public class StockJPADAO implements StockDAO {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public PersistentStock save(PersistentStock persistentStock) {
		entityManager.persist(persistentStock);
		return persistentStock;
	}

	@Override
	public List<PersistentStock> list() {
		TypedQuery<PersistentStock> query = entityManager
				.createQuery("select p from PersistentStock p order by p.id desc", PersistentStock.class);
		query.setMaxResults(15);
		return query.getResultList();
	}

}
