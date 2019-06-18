package com.springbooth.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "country")
public class Country implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "country_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long countryId;

	@Column(name = "country_name")
	private String countryName;
	
	
	

	public Long getCountryId() {
		return countryId;
	}

	public void setCountryId(Long countryId) {
		this.countryId = countryId;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

}
