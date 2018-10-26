package com.example.tpSpringBootJeuVideo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.tpSpringBootJeuVideo.User;

public interface UserRepository extends JpaRepository<User,Long>
{
	User findUserWithName(String username);
}
