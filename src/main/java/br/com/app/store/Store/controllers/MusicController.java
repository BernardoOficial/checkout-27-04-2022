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

import br.com.app.store.Store.dto.MusicDTO;
import br.com.app.store.Store.model.Music;
import br.com.app.store.Store.repositories.MusicRepository;

@Controller
public class MusicController {

	@Autowired
	private MusicRepository musicRepository;

	@Autowired
	private ModelMapper modelMapper;

	@GetMapping("/musics")
	public ModelAndView index() {
		ModelAndView model = new ModelAndView("musics/index");
		List<Music> musics = musicRepository.findAll();
		model.addObject("musics", musics);
		return model;
	}

	@GetMapping("/musics/criar")
	public ModelAndView criar(MusicDTO musicDTO) {
		ModelAndView modelAndView = new ModelAndView("musics/criar");
		return modelAndView;
	}

	@PostMapping("/musics")
	public ModelAndView salvar(@Valid MusicDTO musicDTO, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return new ModelAndView("musics/criar");
		}

		Music music = modelMapper.map(musicDTO, Music.class);
		musicRepository.save(music);
		return new ModelAndView("redirect:/musics");
	}

}
