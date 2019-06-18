package com.springbooth.model.dto;

import com.springbooth.model.entity.Country;

public class PlayersDTO {

	private Long playerId;
	private String playersName;
	private String roleplayers;
	private int age;

	private String playerAge;

	private Long countryId;
	private CountryDTO countryDTO;

	public Long getPlayerId() {
		return playerId;
	}

	public void setPlayerId(Long playerId) {
		this.playerId = playerId;
	}

	public String getPlayersName() {
		return playersName;
	}

	public void setPlayersName(String playersName) {
		this.playersName = playersName;
	}

	public String getRoleplayers() {
		return roleplayers;
	}

	public void setRoleplayers(String roleplayers) {
		this.roleplayers = roleplayers;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Long getCountryId() {
		return countryId;
	}

	public void setCountryId(Long countryId) {
		this.countryId = countryId;
	}

	public CountryDTO getCountryDTO() {
		if (countryDTO == null)
			countryDTO = new CountryDTO();
		return countryDTO;
	}

	public void setCountryDTO(CountryDTO countryDTO) {
		this.countryDTO = countryDTO;
	}

	public String getPlayerAge() {
		return playerAge;
	}

	public void setPlayerAge(String playerAge) {
		this.playerAge = playerAge;
	}

}
