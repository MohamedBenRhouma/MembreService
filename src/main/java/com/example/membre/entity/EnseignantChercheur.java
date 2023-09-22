package com.example.membre.entity;



import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.Date;


@NoArgsConstructor
@Entity @DiscriminatorValue("ens")
public class EnseignantChercheur extends Membre{


    @NonNull
    private String grade;

    @NonNull
    private String etablissement;

    @Builder
    public EnseignantChercheur(String cin, String nom, String prenom, Date dateNaissance, String cv,
                               String email, String password, String grade ,String  etablissement ){

        super( cin, nom, prenom, dateNaissance, cv, email, password);
        this.grade = grade;
        this.etablissement =etablissement ;


    }
}
