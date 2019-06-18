package com.springbooth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springbooth.model.dto.CountryDTO;
import com.springbooth.service.CountryService;

@Controller
public class CountryController {

	@Autowired
	private CountryService countryService;

	// view-country.............
	@RequestMapping(path = "/countryUrl")
	public String home(Model model) {
		try {
			model.addAttribute("countryDTO", new CountryDTO());
			model.addAttribute("countrys", countryService.findAllCauntry());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "country_list";
	}

	@RequestMapping(path = "/countryListUrl")
	public String categoryListUrl(Model model) {
		try {
			model.addAttribute("countryDTO", new CountryDTO());
			model.addAttribute("countrys", countryService.findAllCauntry());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "country_list";
	}

	@RequestMapping(path = "/fetch-countrypage", method = RequestMethod.GET)
	public String fetchCountryPage(Model model) {
		CountryDTO countryDTO = new CountryDTO();
		model.addAttribute("countryDTO", countryDTO);
		return "country";
	}

	// save-country.....................
	@RequestMapping(path = "/saveCountry", method = RequestMethod.POST)
	public String saveCate(CountryDTO countryDTO) {
		try {
			countryService.saveCate(countryDTO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/countryUrl";
	}

	// edit-country..................
	@RequestMapping(path = "/country/edit/{countryId}", method = RequestMethod.GET)
	public String editCountry(Model model, @PathVariable(value = "countryId") Long countryId) {
		try {
			model.addAttribute("countryDTO", countryService.findByCountryId(countryId));
			model.addAttribute("countryList", countryService.findAllCauntry());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "country";
	}

	// delete-country..........
	@RequestMapping(path = "/country/delete/{countryId}", method = RequestMethod.GET)
	public String deleteCountry(Model model, @PathVariable(value = "countryId") Long countryId) {
		try {
			CountryDTO countryDTO = new CountryDTO();
			countryDTO.setCountryId(countryId);
			countryService.deleteCountry(countryDTO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/countryListUrl";
	}

}
