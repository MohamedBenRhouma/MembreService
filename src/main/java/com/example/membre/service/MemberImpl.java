package com.example.membre.service;

import com.example.membre.dao.EnseignatChercheurRepository;
import com.example.membre.dao.EtudiantRepository;
import com.example.membre.dao.MembreRepository;
import com.example.membre.entity.EnseignantChercheur;
import com.example.membre.entity.Etudiant;
import com.example.membre.entity.Membre;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
@AllArgsConstructor
@Service
public class MemberImpl implements IMemberService {

    MembreRepository memberRepository;
    EtudiantRepository etudiantRepository;
    EnseignatChercheurRepository enseignatChercheurRepository;

    @Override
    public List<Etudiant> findEtudinatByEncadrant(EnseignantChercheur ens) {
return etudiantRepository.findByEncadrant(ens);

    }

    @Override
    public void affecterEtudianttoEnseignant(long idEs, long idE) {
      Etudiant etudiant = etudiantRepository.findById(idE).get();
        EnseignantChercheur enseignantChercheur= enseignatChercheurRepository.findById(idEs).get();
        etudiant.setEncadrant(enseignantChercheur);
        etudiantRepository.save(etudiant);


    }

    public Membre addMember(Membre m) {
        memberRepository.save(m);
        return m;
    }
    public void deleteMember(Long id) {
        memberRepository.deleteById(id);
    }
    public Membre updateMember(Membre m) {
        return memberRepository.saveAndFlush(m);
    }
    public Membre findMember(Long id) {
        return (Membre)memberRepository.findById(id).get();
    }

    @Override
    public List<Membre> findAll() {
         return memberRepository.findAll();
    }

    @Override
    public Membre findByCin(String cin) {

      return   memberRepository.findAllByCin(cin);
    }

    @Override
    public Membre findByEmail(String email) {
         return memberRepository.findByEmail(email);
    }

    @Override
    public List<Membre> findByNom(String nom) {
         return memberRepository.findByNom(nom);
    }

    @Override
    public List<Etudiant> findByDiplome(String diplome) {
       return etudiantRepository.findByDiplome(diplome);
    }

    @Override
    public List<EnseignantChercheur> findByGrade(String grade) {
      return enseignatChercheurRepository.findByGrade(grade);
    }

    @Override
    public List<EnseignantChercheur> findByEtablissement(String etablissement) {
         return  enseignatChercheurRepository.findByEtablissement(etablissement);
    }
}