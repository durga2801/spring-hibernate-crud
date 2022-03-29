package org.durgendra.controller;

import java.util.List;

import org.durgendra.entity.CountryEntity;
import org.durgendra.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CountryController {

	@Autowired
	private CountryService countryService;

	@RequestMapping(value = "/countries", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<CountryEntity> getCountries() {
		List<CountryEntity> listOfCountries = countryService.getAllCountrie();
		return listOfCountries;
	}

	@RequestMapping(value = "/country/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public CountryEntity getCountryById(@PathVariable Long id) {
		return countryService.getCountry(id);
	}

	@RequestMapping(value = "/countries", method = RequestMethod.POST, headers = "Accept=application/json")
	public CountryEntity addCountry(@RequestBody CountryEntity country) {
		return countryService.saveCountry(country);
	}

	@RequestMapping(value = "/countries", method = RequestMethod.PUT, headers = "Accept=application/json")
	public CountryEntity updateCountry(@RequestBody CountryEntity country) {
		return countryService.updateCountry(country);

	}

	@RequestMapping(value = "/country/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public void deleteCountry(@PathVariable("id") Long id) {
		countryService.delete(id);
	}	
}
