package com.example.membre;

import com.example.membre.beans.PublicationBean;
import com.example.membre.dao.MembreRepository;
import com.example.membre.entity.EnseignantChercheur;
import com.example.membre.entity.Etudiant;
import com.example.membre.entity.Membre;
import com.example.membre.service.IMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication
public class MemberApplication implements CommandLineRunner {
	@Autowired
		MembreRepository membreRepository ;
	@Autowired
	IMemberService memberService;

	public static void main(String[] args) {
		SpringApplication.run(MemberApplication.class, args);

	}
	@Override
	public void run(String... args) throws Exception  {



		Etudiant etd1=Etudiant.builder()
				.cin("123456")
				.dateInscription(new Date())
				.dateNaissance(new Date())
				.diplome("mastère")
				.email("etd1@gmail.com")
				.password("pass1")
				.encadrant(null)
				.cv("cv1")
				.nom("abid")
				.prenom("youssef)")
				.sujet("blockhain")
				.build();
		Etudiant etd2=Etudiant.builder()
				.cin("135790")
				.dateInscription(new Date())
				.dateNaissance(new Date())
				.diplome("ingénieur")
				.email("etd2@gmail.com")
				.password("pass2")
				.encadrant(null)
				.cv("cv2")
				.nom("benrhouma")
				.prenom("hama")
				.sujet("AI")
				.build();
		EnseignantChercheur ens1= EnseignantChercheur.builder()
				.cin("052111")
				.dateNaissance(new Date())
				.email("ens1@gmail.com")
				.password("pass3")
				.cv("cv3")
				.nom("mnassar")
				.prenom("dali")
				.etablissement("enis")
				.grade("senior").build();

		EnseignantChercheur ens2= EnseignantChercheur.builder()
				.cin("052222")
				.dateNaissance(new Date())
				.email("ens2@gmail.com")
				.password("pass4")
				.cv("cv4")
				.nom("rebai")
				.prenom("omar")
				.etablissement("enis")
				.grade("dr").build();

		membreRepository.save(etd1);
		membreRepository.save(etd2);
		membreRepository.save(ens1);
		membreRepository.save(ens2);

		List<Membre> membreList = membreRepository.findAll();
		Iterator<Membre> iterator = membreList.iterator();
		while (iterator.hasNext()) {
			Membre membre = iterator.next();
			System.out.println(membre.getNom() + " " + membre.getPrenom());

		};
// Update a Member
		Membre m= memberService.findMember(1L);
		m.setCv("cv1.pdf");
		memberService.updateMember(m);
// Delete a Member
		memberService.deleteMember(2L);

		memberService.affecterEtudianttoEnseignant(3,1);
		memberService.affecterauteurTopublication(1L,1L);


}

	}



