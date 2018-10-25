package com.example.tpSpringBootJeuVideo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.tpSpringBootJeuVideo.User;
import com.example.tpSpringBootJeuVideo.Exception.ResourceNotFoundException;
import com.example.tpSpringBootJeuVideo.Repository.UserRepository;

public class UserService implements IUserService 
{
	@Autowired
	UserRepository userRepo;
	
	
	@PutMapping("/update/User/{id}")
	public User updateById(@PathVariable(value="id") Long usId, @RequestBody User userUp) {
		User user = userRepo.findById(usId)
				.orElseThrow(() -> new ResourceNotFoundException("user", "id", usId));;
		userUp.setUsername(user.getUsername());
		return userRepo.save(userUp);
	}
}
