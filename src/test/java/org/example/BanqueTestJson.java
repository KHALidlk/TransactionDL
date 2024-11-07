package org.example;
import com.google.gson.Gson;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashSet;

public class BanqueTestJson {

    private Banque banque;
    private ArrayList<Compte> comptes;

    @BeforeEach
    void setUp() {
        comptes = new ArrayList<>();
        // Création de quelques comptes pour les tests
        comptes.add(new Compte(1, null, null, "MAD", null, 1000.0, null, new HashSet<>()));
        comptes.add(new Compte(2, null, null, "EUR", null, 2000.0, null, new HashSet<>()));

        // Initialisation de l'objet Banque
        banque = new Banque(1, "Morocco", comptes);
    }

    @Test
    public void testBanqueToJson() {
        // Act
        String json = banque.toJson();

        // Assert
        assertTrue(json.contains("\"id\":1"));
        assertTrue(json.contains("\"pay\":\"Morocco\""));
        assertTrue(json.contains("\"comptes\":[{"));
    }

    @Test
    public void testBanqueFromJson() {
        // Arrange
        String json = "{\"id\":1,\"pay\":\"Morocco\",\"comptes\":[{\"id\":1},{\"id\":2}]}";

        // Act
        Banque banqueFromJson = new Banque().fromJson(json);

        // Assert
        assertEquals(1, banqueFromJson.getId());
        assertEquals("Morocco", banqueFromJson.getPay());
        assertNotNull(banqueFromJson.getComptes());
        assertEquals(2, banqueFromJson.getComptes().size());
    }
}
