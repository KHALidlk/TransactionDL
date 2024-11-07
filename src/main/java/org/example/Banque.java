package org.example;
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
}