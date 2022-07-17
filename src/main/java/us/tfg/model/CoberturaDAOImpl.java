package us.tfg.model;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CoberturaDAOImpl implements CoberturaDAO {

	@Autowired
	private EntityManager entityManager;

	@Override
	public void save(Cobertura cobertura) {
		Session currentSession = entityManager.unwrap(Session.class);

		currentSession.saveOrUpdate(cobertura);
	}

}
