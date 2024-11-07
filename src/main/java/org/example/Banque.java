package org.example;
import com.google.gson.Gson;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.ArrayList;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Banque {
    private int id;
    private String pay;
    private ArrayList<Compte> comptes;
    public String toJson() {
        Gson gson = new Gson();
        return gson.toJson(this); // Convertir l'objet actuel en JSON
    }
    // Conversion d'une chaîne JSON en objet Compte
    public static Banque fromJson(String json) {
        Gson gson = new Gson();
        return gson.fromJson(json, Banque.class); // Convertir JSON en objet Compte
    }
}