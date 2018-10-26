package com.example.tpSpringBootJeuVideo.Service;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;	

import com.example.tpSpringBootJeuVideo.User;
import com.example.tpSpringBootJeuVideo.Exception.ResourceNotFoundException;
import com.example.tpSpringBootJeuVideo.Exception.UserNameNotFoundException;
import com.example.tpSpringBootJeuVideo.Repository.UserRepository;
@Service
public class UserService implements IUserService,UserDetailsService
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
	
	@Autowired
	public UserService (UserRepository userRepo)
	{
		this.userRepo= userRepo;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Objects.requireNonNull(username);
       // User user = userRepo.findUserWithName(username)
        //		.orElseThrow(() -> new UsernameNotFoundException("User not found"));
        return null;
	}

	
	
	
}