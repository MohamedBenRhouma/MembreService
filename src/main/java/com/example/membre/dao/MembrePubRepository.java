package com.example.membre.dao;

import com.example.membre.entity.Membre;
import com.example.membre.entity.Membre_Pub_Id;
import com.example.membre.entity.Membre_Publication;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MembrePubRepository extends JpaRepository<Membre_Publication, Membre_Pub_Id> {
    List<Membre_Publication> findByAuteur(Membre auteur);
}