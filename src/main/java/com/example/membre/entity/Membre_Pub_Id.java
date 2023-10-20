package com.example.membre.entity;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
 @Data
 @AllArgsConstructor
 @NoArgsConstructor
@Embeddable
public class Membre_Pub_Id  implements Serializable {
    private Long publication_id;
    private Long auteur_id;
}
