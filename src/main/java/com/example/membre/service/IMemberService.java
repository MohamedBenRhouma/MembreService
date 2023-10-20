package com.example.membre.service;

import com.example.membre.beans.PublicationBean;
import com.example.membre.entity.EnseignantChercheur;
import com.example.membre.entity.Etudiant;
import com.example.membre.entity.Membre;

import java.util.List;

public interface IMemberService {


    List<Etudiant> findEtudinatByEncadrant(EnseignantChercheur ens);
     public void affecterEtudianttoEnseignant(long idEs,long idE);
    public Membre addMember(Membre m);
    public void deleteMember(Long id) ;
    public Membre updateMember(Membre p) ;
    public Membre findMember(Long id) ;
    public List<Membre> findAll();

    public Membre findByCin(String cin);
    public Membre findByEmail(String email);
    public List<Membre> findByNom(String nom);
    //recherche spécifique des étudiants
    public List<Etudiant> findByDiplome(String diplome);
    //recherche spécifique des enseignants
    public List<EnseignantChercheur> findByGrade(String grade);
    public List<EnseignantChercheur> findByEtablissement(String etablissement);

    public void affecterauteurTopublication(Long id_membre, Long idpub);
    public List<PublicationBean> findPublicationparauteur (Long idauteur);}