package com.springbooth.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springbooth.model.entity.Players;

public interface PlayersRepo extends JpaRepository<Players, Long> {

	List<Players> findByCountry_CountryId(Long countryId);

}
