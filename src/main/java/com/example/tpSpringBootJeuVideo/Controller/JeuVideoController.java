package com.example.tpSpringBootJeuVideo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.tpSpringBootJeuVideo.JeuVideo;
import com.example.tpSpringBootJeuVideo.Exception.ResourceNotFoundException;
import com.example.tpSpringBootJeuVideo.Repository.JeuVideoRepository;

@RestController
@RequestMapping("api/videoGames")
public class JeuVideoController
{
	@Autowired
    JeuVideoRepository jvRepo;

	@GetMapping("/")
	public List<JeuVideo> getAll(){
		return jvRepo.findAll();
	}
	
	@GetMapping("/{id}")
	public JeuVideo getById(@PathVariable(value ="id") Long jvId) {
		return jvRepo.findById(jvId)
				.orElseThrow(() -> new ResourceNotFoundException("Jeu", "id", jvId));
	}
	
	@PostMapping("/")
	public JeuVideo create(@RequestBody JeuVideo game) {
	    return jvRepo.save(game);
	}
	
	@PutMapping("/{id}")
	public JeuVideo updateById(@PathVariable(value="id") Long jvId, @RequestBody JeuVideo gameUp) {
		JeuVideo game = jvRepo.findById(jvId)
				.orElseThrow(() -> new ResourceNotFoundException("Jeu", "id", jvId));;
		gameUp.setEditeur(game.getEditeur());
		gameUp.setDateSortie(game.getDateSortie());
		gameUp.setTitre(game.getTitre());
		return jvRepo.save(gameUp);
	}
	
	@DeleteMapping("/{id}")
	public JeuVideo deleteById(@PathVariable(value="id") Long jvId) {
		JeuVideo game = jvRepo.findById(jvId)
				.orElseThrow(() -> new ResourceNotFoundException("Jeu", "id", jvId));;
		jvRepo.delete(game);
		return null;
		
	}
}
