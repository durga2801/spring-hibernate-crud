package org.durgendra.repository;

import java.util.List;

import org.durgendra.entity.CountryEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CountryRepository {
	
	
	@Autowired
	private HibernateTemplate template;
	
	Session session;
	
	public CountryEntity save(CountryEntity entity) {
		template.save(entity);
		return entity;
	}

	public void deleteEntity(Long id) {
		CountryEntity country = getCountry(id);
		template.delete(country);
	}
	
	public CountryEntity getCountry(Long id) {
		CountryEntity country = template.get(CountryEntity.class, id);
		return country;
	}
	
	public CountryEntity updateCountry(CountryEntity entity) {
		template.update(entity);
		return entity;
	}

	public List<CountryEntity> getAllCountries() {
		return (List<CountryEntity>) template.find("from "+CountryEntity.class.getCanonicalName());
	}
	
	public CountryEntity save1(CountryEntity entity) {
		Transaction transaction = null;
		try {
			session = template.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.save(entity);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			session.close();
		}
		return entity;
	} 
	
	

}
