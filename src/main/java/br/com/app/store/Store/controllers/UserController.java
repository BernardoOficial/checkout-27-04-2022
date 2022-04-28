package br.com.app.store.Store.controllers;

import java.util.List;
import java.util.Optional;

import javax.servlet.RequestDispatcher;
import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

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

	@PostMapping("/create-user")
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
	
	public ModelAndView loginValidate(RedirectAttributes redirectAttributes, @Valid UserDTO userDTO, BindingResult bindingResult) {
		
		if(bindingResult.hasErrors()) {
			return new ModelAndView("/login");
		}

		User user = modelMapper.map(userDTO, User.class);
		List<User> usersDatabase = userRepository.findAll();
		
		User userMatch = null;
		
		for (User userDb : usersDatabase) {
	        if (userDb.getUsername().equals(user.getUsername())) {
	        	userMatch = userDb;
	        }
	    }
		
		if(userMatch != null) {
			System.out.println(userMatch.getUsername());
			System.out.println(userMatch.getPassword());
			
			if(
				userMatch.getPassword().equalsIgnoreCase(user.getPassword()) &&
				userMatch.getUsername().equalsIgnoreCase(user.getUsername())
			) {				
				System.out.println("partiu dashboard");
				redirectAttributes.addFlashAttribute("user", userMatch);
				ModelAndView modelAndView = new ModelAndView("redirect:/dashboard");
				return modelAndView;
			}
			
		}
		
		return new ModelAndView("/login");
		
	}
	
	@GetMapping("/dashboard")
	public ModelAndView dashboard( @ModelAttribute("user") User user, @Valid UserDTO userDTO, BindingResult bindingResult) {
		
		System.out.println(user.getUsername());
		System.out.println(user.getPassword());
		
		ModelAndView modelAndView = new ModelAndView("dashboard");
		modelAndView.addObject("user", user);
		
		return modelAndView;
	}

}
