package com.springbooth.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "players")
public class Players implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "player_Id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long playerId;

	@Column(name = "players_Name")
	private String playersName;

	@Column(name = "roleplayers")
	private String roleplayers;
	
	@Column(name = "age")
	private int age;
	
	@Column(name = "player_age")
	private String playerAge;
	
	@ManyToOne
	@JoinColumn(name = "country_id")
	private Country country;

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

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public String getPlayerAge() {
		return playerAge;
	}

	public void setPlayerAge(String playerAge) {
		this.playerAge = playerAge;
	}

}
