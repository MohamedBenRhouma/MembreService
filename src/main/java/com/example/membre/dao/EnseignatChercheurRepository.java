package com.example.membre.dao;

import com.example.membre.entity.EnseignantChercheur;
import com.example.membre.entity.Membre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EnseignatChercheurRepository extends JpaRepository<EnseignantChercheur,Long> {
    List<EnseignantChercheur> findByGrade(String grade);
    List<EnseignantChercheur>findByEtablissement(String etablissement);
}
