package com.example.tpSpringBootJeuVideo;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name= "JEUXVIDEOS")
public class JeuVideo implements Serializable{
	 
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    @Column(name="titre")
	private String titre;
    @Column(name="dateSortie")
	private LocalDate dateSortie;
    @Column(name="editeur")
	private String editeur;
    
    public JeuVideo() {}
    
	public JeuVideo(Long id, String titre, LocalDate dateSortie, String editeur) {
		super();
		this.id = id;
		this.titre = titre;
		this.dateSortie = dateSortie;
		this.editeur = editeur;
	}
	public long getId() {
		return id;
	}
	public void setId( Long id) {
		this.id = id;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public LocalDate getDateSortie() {
		return dateSortie;
	}
	public void setDateSortie(LocalDate dateSortie) {
		this.dateSortie = dateSortie;
	}
	public String getEditeur() {
		return editeur;
	}
	public void setEditeur(String editeur) {
		this.editeur = editeur;
	}
	
}