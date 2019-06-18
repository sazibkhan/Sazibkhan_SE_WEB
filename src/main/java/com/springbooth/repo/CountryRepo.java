package com.springbooth.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springbooth.model.entity.Country;


public interface CountryRepo extends JpaRepository<Country, Long>{

}
