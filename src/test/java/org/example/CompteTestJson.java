//package org.example;
//import com.google.gson.Gson;
//import org.junit.jupiter.api.Test;
//import java.util.HashSet;
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertTrue;
//public class CompteTestJson {
//    @Test
//    public void testCompteToJson() {
//        Compte compte = new Compte(1, null, null, "MAD", null, 1000.0, null, new HashSet<Transaction>());
//        Gson gson = new Gson();
//        String json = gson.toJson(compte);
//        assertTrue(json.contains("\"numCompte\":1"));
//        assertTrue(json.contains("\"devise\":\"MAD\""));
//        assertTrue(json.contains("\"solde\":1000.0"));
//    }
//    @Test
//    public void testCompteFromJson() {
//        String json = "{\"numCompte\":1,\"dateCreation\":null,\"dateUpdate\":null,\"devise\":\"MAD\",\"numclient\":null,\"solde\":1000.0,\"idBanque\":null,\"transactions\":[]}";
//        Compte compte = Compte.fromJson(json);
//        assertEquals(1, compte.getNumCompte());
//        assertEquals("MAD", compte.getDevise());
//        assertEquals(1000.0, compte.getSolde());
//    }
//}
