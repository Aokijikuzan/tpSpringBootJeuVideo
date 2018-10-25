package com.example.tpSpringBootJeuVideo.Service;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.tpSpringBootJeuVideo.User;

public interface IUserService 
{
	User updateById(@PathVariable(value="id") Long usId, @RequestBody User userUp);
}
