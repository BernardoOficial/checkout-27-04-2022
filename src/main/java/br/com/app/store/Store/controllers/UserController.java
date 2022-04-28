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

import br.com.app.store.Store.dto.UserDTO;
import br.com.app.store.Store.model.User;
import br.com.app.store.Store.repositories.UserRepository;

@Controller
public class UserController {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ModelMapper modelMapper;

	@GetMapping("/create-user")
	public ModelAndView user(UserDTO userDTO) {
		ModelAndView modelAndView = new ModelAndView("create-user");
		return modelAndView;
	}

	@PostMapping("/user")
	public ModelAndView createUser(@Valid UserDTO userDTO, BindingResult bindingResult) {
		
		if(bindingResult.hasErrors()) {
			return new ModelAndView("create-user");
		}

		User user = modelMapper.map(userDTO, User.class);
		userRepository.save(user);
		return new ModelAndView("redirect:/login");
	}
	
	@GetMapping("/login")
	public ModelAndView login(UserDTO userDTO) {
		ModelAndView modelAndView = new ModelAndView("login");
		return modelAndView;
	}

	@PostMapping("/login")
	public ModelAndView loginValidate(@Valid UserDTO userDTO, BindingResult bindingResult) {
		
		if(bindingResult.hasErrors()) {
			return new ModelAndView("login");
		}

		User user = modelMapper.map(userDTO, User.class);
		userRepository.save(user);
		return new ModelAndView("redirect:/dashboard");
	}
	
	@GetMapping("dashboard")
	public ModelAndView login(@Valid UserDTO userDTO, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView("dashboard");
		return modelAndView;
	}

}
