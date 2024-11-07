package org.example;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
public class Main {
    public static void main(String[] args) {
        // Création des banques
        Banque banque1 = new Banque();
        banque1.setId(1);
        banque1.setPay("Maroc");

        Banque banque2 = new Banque();
        banque2.setId(2);
        banque2.setPay("Maroc");

        Banque banque3 = new Banque();
        banque3.setId(3);
        banque3.setPay("France");

        // Création des clients
        Client client1 = new Client();
        client1.setNumclient(1);
        client1.setNom("Dupont");
        client1.setPrenom("Jean");
        client1.setAdresse("123 rue Paris");
        client1.setPhone("0123456789");
        client1.setEmail("jean@email.com");

        // Création des comptes
        Compte compte1 = new Compte();
        compte1.setNumCompte(1001);
        compte1.setDateCreation(new Date(System.currentTimeMillis()));
        compte1.setDevise("EUR");
        compte1.setNumclient(client1);
        compte1.setSolde(1000.0);
        compte1.setIdBanque(banque1);

        Compte compte2 = new Compte();
        compte2.setNumCompte(1002);
        compte2.setDateCreation(new Date(System.currentTimeMillis()));
        compte2.setDevise("EUR");
        compte2.setNumclient(client1);
        compte2.setSolde(2000.0);
        compte2.setIdBanque(banque1);

        Compte compte3 = new Compte();
        compte3.setNumCompte(1003);
        compte3.setDateCreation(new Date(System.currentTimeMillis()));
        compte3.setDevise("EUR");
        compte3.setNumclient(client1);
        compte3.setSolde(3000.0);
        compte3.setIdBanque(banque2);
        // Test VIRINT (même banque)
        Transaction transactionInterne = new Transaction();
        transactionInterne.setReference("VIRINT_001");
        transactionInterne.setTime(new Date(System.currentTimeMillis()));
        transactionInterne.getComptes().add(compte1);
        transactionInterne.getComptes().add(compte2);
        System.out.println("Type transaction interne: " + transactionInterne.type_Transaction());

        // Test VIREST (même pays, banques différentes)
        Transaction transactionNationale = new Transaction();
        transactionNationale.setReference("VIREST_001");
        transactionNationale.setTime(new Date(System.currentTimeMillis()));
        transactionNationale.getComptes().add(compte1);
        transactionNationale.getComptes().add(compte2);
        System.out.println("Type transaction nationale: " + transactionNationale.type_Transaction());

        // Test VIRMULTA (plus de 2 comptes)
        Transaction transactionMultiple = new Transaction();
        transactionMultiple.setReference("VIRMULTA_001");
        transactionMultiple.setTime(new Date(System.currentTimeMillis()));
        transactionMultiple.getComptes().add(compte1);
        transactionMultiple.getComptes().add(compte2);
        transactionMultiple.getComptes().add(compte3);
        System.out.println("Type transaction multiple: " + transactionMultiple.type_Transaction());

        // Test VIRCHAC (un seul compte)
        Transaction transactionSimple = new Transaction();
        transactionSimple.setReference("VIRCHAC_001");
        transactionSimple.setTime(new Date(System.currentTimeMillis()));
        transactionSimple.getComptes().add(compte1);
        System.out.println("Type transaction simple: " + transactionSimple.type_Transaction());
    }
}