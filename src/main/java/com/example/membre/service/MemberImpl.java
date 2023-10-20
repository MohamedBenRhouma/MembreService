package com.example.membre.service;

import com.example.membre.beans.PublicationBean;
import com.example.membre.dao.EnseignatChercheurRepository;
import com.example.membre.dao.EtudiantRepository;
import com.example.membre.dao.MembrePubRepository;
import com.example.membre.dao.MembreRepository;
import com.example.membre.entity.*;
import com.example.membre.proxies.PublicationProxyService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@AllArgsConstructor

@Service
public class MemberImpl implements IMemberService {
    PublicationProxyService proxy ;

    MembreRepository memberRepository;
    EtudiantRepository etudiantRepository;
    EnseignatChercheurRepository enseignatChercheurRepository;
    MembrePubRepository membrepubrepository;

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

    public void affecterauteurTopublication(Long idauteur, Long idpub)
    {
        Membre mbr= memberRepository.findById(idauteur).get();
        Membre_Publication mbs= new Membre_Publication();
        mbs.setAuteur(mbr);
        mbs.setId(new Membre_Pub_Id(idpub, idauteur));
        membrepubrepository.save(mbs);
    }


    public List<PublicationBean> findPublicationparauteur(Long idauteur) {
        List<PublicationBean> pubs=new ArrayList<PublicationBean>();
        Membre auteur= memberRepository.findById(idauteur).get();
        List< Membre_Publication>
                idpubs=membrepubrepository.findByAuteur(auteur);
        idpubs.forEach(s->{
                    System.out.println(s);
                    pubs.add(proxy.recupererUnePublication(s.getId().getPublication_id()));
                }
        );
        return pubs;
    }

}