package com.example.tpSpringBootJeuVideo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.tpSpringBootJeuVideo.JeuVideo;

@Repository
public interface JeuVideoRepository extends JpaRepository<JeuVideo,Long> {}
