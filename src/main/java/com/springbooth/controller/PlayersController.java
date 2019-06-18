package com.springbooth.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.springbooth.model.dto.CountryDTO;
import com.springbooth.model.dto.PlayersDTO;
import com.springbooth.service.CountryService;
import com.springbooth.service.PlayersService;

@Controller
public class PlayersController {
	@Autowired
	private CountryService countryService;

	@Autowired
	private PlayersService playersService;

	// view-plaryes.......
	@RequestMapping(path = "/playersUrl", method = RequestMethod.GET)
	public String players(Model model) {
		model.addAttribute("playersDTO", new PlayersDTO());
		model.addAttribute("players", playersService.findAllPlayers());
		return "players-list";
	}

	@RequestMapping(path = "/playersListUrl", method = RequestMethod.GET)
	public String playersListUrl(Model model) {
		try {
			model.addAttribute("playersDTO", new PlayersDTO());
			model.addAttribute("players", playersService.findAllPlayers());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "players-list";
	}

	@RequestMapping(path = "/fetch-playerpage", method = RequestMethod.GET)
	public String fetchPlayersPage(Model model) {
		try {
			PlayersDTO playersDTO = new PlayersDTO();
			model.addAttribute("playersDTO", playersDTO);
			model.addAttribute("countrys", countryService.findAllCauntry());
		} catch (Exception e) {
			System.out.println(e);
		}
		return "players";
	}

	@RequestMapping(path = "/homeUrl", method = RequestMethod.GET)
	public String home(Model model) {
		model.addAttribute("countryDTO", new CountryDTO());
		model.addAttribute("countrys", countryService.findAllCauntry());
		/* model.addAttribute("players", playersService.findAllPlayers()); */
		return "home_page";
	}

	@RequestMapping(path = "/players/by/country-id")
	public String playerByCountryIdView(Model model, @RequestParam Long countryId) {
		try {
			model.addAttribute("players", playersService.findAllPlayersByCountryId(countryId));
			List<CountryDTO> countryDTOs = countryService.findAllCauntry();
			model.addAttribute("countrys", countryDTOs);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "home_page";
	}

	// save-plaryes.......
	@RequestMapping(path = "/savePlayerUrl", method = RequestMethod.POST)
	public String savePlayer(PlayersDTO playersDTO) {
		try {
			playersService.savePlayer(playersDTO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/playersUrl";
	}

	// edit-player...........
	@RequestMapping(path = "/player/edit/{playerId}", method = RequestMethod.GET)
	public String editPlayer(Model model, @PathVariable(value = "playerId") Long playerId) {
		try {
			PlayersDTO playersDTO = playersService.findByPlayerId(playerId);
			model.addAttribute("playersDTO", playersDTO);
			model.addAttribute("players", playersService.findAllPlayers());
			model.addAttribute("countrys", countryService.findAllCauntry());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "players";
	}

	// delete-player...........
	@RequestMapping(path = "/player/delete/{playerId}", method = RequestMethod.GET)
	public String deletePlayer(Model model, @PathVariable(value = "playerId") Long playerId) {
		try {
			PlayersDTO playersDTO = new PlayersDTO();
			playersDTO.setPlayerId(playerId);
			playersService.deletePlayer(playersDTO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/playersListUrl";

	}

}
