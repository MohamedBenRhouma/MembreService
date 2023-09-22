package com.example.membre.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Entity
@DiscriminatorValue("etd")
public class Etudiant extends Membre{
    @NonNull
    @Temporal(TemporalType.DATE)

    @ManyToOne
    private EnseignantChercheur encadrant;

    private Date dateInscription;

    private String diplome;
    private  String sujet ;

    @Builder
    public Etudiant( String cin, String nom, String prenom, Date dateNaissance,
                     String cv,
                     String email, String password, Date dateInscription, String sujet, String
                             diplome,
                     EnseignantChercheur encadrant) {
        super( cin, nom, prenom, dateNaissance, cv, email, password);
        this.dateInscription = dateInscription;
        this.sujet=sujet;
        this.diplome=diplome;
        this.encadrant=encadrant;


    }

}
