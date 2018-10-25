package com.example.tpSpringBootJeuVideo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.tpSpringBootJeuVideo.User;
import com.example.tpSpringBootJeuVideo.Exception.ResourceNotFoundException;
import com.example.tpSpringBootJeuVideo.Repository.UserRepository;
@RestController
@RequestMapping("api/user")
public class UserController 
{
	@Autowired
	UserRepository userRepo;
	
	@GetMapping("/Users")
	public List<User> getAll()
	{
		return userRepo.findAll();
	}
	@GetMapping("/Users/{id}")
	public User getById(@PathVariable(value="id") Long usId)
	{
		return userRepo.findById(usId)
				.orElseThrow(() ->new ResourceNotFoundException("user", "id", usId));
	}
	
	@PostMapping("/create/User")
	public User create(@RequestBody User usId) {
	    return userRepo.save(usId);
	}
	
	
}
