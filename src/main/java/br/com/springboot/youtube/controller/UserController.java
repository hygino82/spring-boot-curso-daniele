package br.com.springboot.youtube.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.springboot.youtube.model.User;
import br.com.springboot.youtube.repository.UserRepository;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserRepository userRepository;

	// private List<User> users = new ArrayList<>();

	@GetMapping("/{id}")
	public User getUser(@PathVariable("id") Long id) {

		Optional<User> userFind = this.userRepository.findById(id);
		if (userFind.isPresent()) {
			return userFind.get();
		}
		return null;
	}

	@PostMapping("/")
	public User add(@RequestBody User user) {
		return this.userRepository.save(user);
	}

	@GetMapping("/list")
	public List<User> getAllUsers() {
		return this.userRepository.findAll();
	}
	
	@GetMapping("/list/{id}")
	public List<User> listMoreThan(@PathVariable("id")Long id) {
		return this.userRepository.findByIdGreaterThan(id);
	}
	
	@GetMapping("/findByName/{name}")
	public List<User> findByName(@PathVariable("name")String name) {
		return this.userRepository.findByName(name);
	}
	
	@GetMapping("/findByNameIgnoreCase/{name}")
	public List<User> findByNameIgnoreCase(@PathVariable("name")String name) {
		return this.userRepository.findByNameIgnoreCase(name);
	}

}
