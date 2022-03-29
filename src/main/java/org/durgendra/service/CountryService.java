package org.durgendra.service;

import java.util.List;

import javax.transaction.Transactional;

import org.durgendra.entity.CountryEntity;
import org.durgendra.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*
 * It is just a helper class which should be replaced by database implementation.
 * It is not very well written class, it is just used for demonstration.
 */
@Service
public class CountryService {

	@Autowired
	private CountryRepository repo;

	/******************************************************************************/
	
	public void delete(Long id) {
		repo.deleteEntity(id);
	}
	
	public CountryEntity getCountry(Long id) {
		return repo.getCountry(id);
	}

	@Transactional
	public CountryEntity saveCountry(CountryEntity country)	{
		repo.save1(country);
		return country;
	}
	
	public CountryEntity updateCountry(CountryEntity country) {
		return repo.updateCountry(country);
	}
	
	public List<CountryEntity> getAllCountrie(){
		return repo.getAllCountries();
	}
	
}

