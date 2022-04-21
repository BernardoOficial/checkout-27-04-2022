package br.com.app.store.Store.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.app.store.Store.dto.GameDTO;
import br.com.app.store.Store.model.Game;
import br.com.app.store.Store.repositories.GameRepository;

@Controller
public class GameController {

	@Autowired
	private GameRepository gameRepository;

	@Autowired
	private ModelMapper modelMapper;

	@GetMapping("/games")
	public ModelAndView index() {
		ModelAndView model = new ModelAndView("games/index");
		List<Game> games = gameRepository.findAll();
		model.addObject("games", games);
		return model;
	}

	@GetMapping("/games/criar")
	public ModelAndView criar(GameDTO gameDTO) {
		ModelAndView modelAndView = new ModelAndView("games/criar");
		return modelAndView;
	}

	@PostMapping("/games")
	public ModelAndView salvar(@Valid GameDTO gameDTO, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return new ModelAndView("games/criar");
		}

		Game game = modelMapper.map(gameDTO, Game.class);
		gameRepository.save(game);
		return new ModelAndView("redirect:/games");
	}

}
