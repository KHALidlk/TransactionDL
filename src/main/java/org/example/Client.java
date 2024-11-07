package org.example;

import com.google.gson.Gson;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Client {
    private int numclient;
    private String nom;
    private String prenom;
    private String adresse;
    private String phone;
    private String email;
    private Set<Compte> comptes;
    public String to_json()
    {
        Gson gson=new Gson();
        return gson.toJson(this);
    }

    Client fromjson(String json)
    {
        Gson gson=new Gson();
        return gson.fromJson(json,Client.class);
    }
}