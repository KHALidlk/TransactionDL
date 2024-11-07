package org.example;
import com.google.gson.Gson;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
@Data
@AllArgsConstructor
@NoArgsConstructor
    public class Compte {
        private int numCompte;
        private Date dateCreation;
        private Date dateUpdate;
        private String devise;
        private Client numclient;
        private double solde;
        private Banque idBanque;
        private Set<Transaction> transactions= new HashSet<>();
    public String toJson() {
        Gson gson = new Gson();
        return gson.toJson(this); // Convertir l'objet actuel en JSON
    }
    // Conversion d'une chaîne JSON en objet Compte
    public static Compte fromJson(String json) {
        Gson gson = new Gson();
        return gson.fromJson(json, Compte.class); // Convertir JSON en objet Compte
    }
    }
