package com.springbooth.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springbooth.model.dto.CountryDTO;
import com.springbooth.model.entity.Country;
import com.springbooth.repo.CountryRepo;

@Service
@Transactional 
public class CountryService {

	@Autowired
	private CountryRepo countryRepo;

	// save-country..............................
	public void saveCate(CountryDTO countryDTO) {
		countryRepo.save(copyDtoToEntity(countryDTO));
	}

	public Country copyDtoToEntity(CountryDTO countryDTO) {
		Country country = new Country();
		BeanUtils.copyProperties(countryDTO, country);
		return country;
	}
	// view-country..............
	public List<CountryDTO> findAllCauntry() {
		List<CountryDTO> countryDTOList = new ArrayList<>();
		List<Country> countryList = new ArrayList<>();
		countryList = countryRepo.findAll();
		for (Country country : countryList) {
			countryDTOList.add(copyEntityToDto(country));
		}
		return countryDTOList;
	}

	public CountryDTO copyEntityToDto(Country country) {
		CountryDTO countryDTO = new CountryDTO();
		BeanUtils.copyProperties(country, countryDTO);
		return countryDTO;
	}

	
// edit-country..................
	public CountryDTO findByCountryId(Long countryId) {
		CountryDTO countryDTO=new CountryDTO();
		Country country=new Country();
		country=countryRepo.getOne(countryId);
		BeanUtils.copyProperties(country, countryDTO);
		return countryDTO;
	}
	
	// delete-country...............
	public void deleteCountry(CountryDTO countryDTO) {
		countryRepo.deleteById(countryDTO.getCountryId());
		
	}



}
