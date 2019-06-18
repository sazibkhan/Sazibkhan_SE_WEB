package com.springbooth.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springbooth.model.dto.CountryDTO;
import com.springbooth.model.dto.PlayersDTO;
import com.springbooth.model.entity.Country;
import com.springbooth.model.entity.Players;
import com.springbooth.repo.CountryRepo;
import com.springbooth.repo.PlayersRepo;

@Service
@Transactional
public class PlayersService {

	@Autowired
	private PlayersRepo playersRepo;

	@Autowired
	private CountryRepo countryRepo;

	// save-plaryes.......
	public void savePlayer(PlayersDTO playersDTO) {
		playersRepo.save(copyDtoToEntity(playersDTO));
	}

	public Players copyDtoToEntity(PlayersDTO playersDTO) {
		Players players = new Players();
		BeanUtils.copyProperties(playersDTO, players);
		Country country = countryRepo.getOne(playersDTO.getCountryDTO().getCountryId());
		players.setCountry(country);
		return players;
	}

	// view-plaryes.......
	public List<PlayersDTO> findAllPlayers() {
		List<PlayersDTO> playersDTOList = new ArrayList<>();
		List<Players> playerList = new ArrayList<>();
		playerList = playersRepo.findAll();
		for (Players player : playerList) {
			playersDTOList.add(copyEntityToDto(player));
		}
		return playersDTOList;
	}

	public PlayersDTO copyEntityToDto(Players players) {
		PlayersDTO playersDTO = new PlayersDTO();
		CountryDTO countryDTO = new CountryDTO();
		playersDTO.setPlayerId(players.getPlayerId());
		playersDTO.setPlayersName(players.getPlayersName());
		playersDTO.setRoleplayers(players.getRoleplayers());
		playersDTO.setAge(players.getAge());
		playersDTO.setPlayerAge(players.getPlayerAge());

		BeanUtils.copyProperties(players.getCountry(), countryDTO);
		playersDTO.setCountryDTO(countryDTO);
		return playersDTO;
	}

	// edit-Player..................
	public PlayersDTO findByPlayerId(Long playerId) {
		PlayersDTO playersDTO = new PlayersDTO();
		CountryDTO countryDTO = new CountryDTO();
		Players players = new Players();
		players = playersRepo.getOne(playerId);
		BeanUtils.copyProperties(players, playersDTO);
		BeanUtils.copyProperties(players.getCountry(), countryDTO);
		playersDTO.setCountryDTO(countryDTO);
		return playersDTO;

	}

	// delete-Players...............
	public void deletePlayer(PlayersDTO playersDTO) {
		playersRepo.deleteById(playersDTO.getPlayerId());

	}

	// find-All-Players-By-CountryId............
	public List<PlayersDTO> findAllPlayersByCountryId(Long countryId) {
		List<PlayersDTO> playersDTOList = new ArrayList<>();
		List<Players> playerList = new ArrayList<>();
		playerList = playersRepo.findByCountry_CountryId(countryId);
		for (Players player : playerList) {
			playersDTOList.add(copyEntityToDto(player));
		}
		return playersDTOList;
	}

}
