package org.example;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.HashSet;
import java.util.Set;
import static org.junit.jupiter.api.Assertions.*;
public class ClientTestJson {
        private Client client;
        private Set<Compte> comptes;
        @BeforeEach
        void setUp() {
            comptes = new HashSet<>();
            // Création de quelques comptes pour les tests
            comptes.add(new Compte(1, null, null, "MAD", null, 1000.0, null, new HashSet<>()));
            comptes.add(new Compte(2, null, null, "EUR", null, 2000.0, null, new HashSet<>()));
        }

        @Test
        public void testClientToJson() {
            // Arrange
            client = new Client(
                    1,
                    "Doe",
                    "John",
                    "123 Main St",
                    "+212666778899",
                    "john.doe@email.com",
                    comptes
            );

            // Act
            String json = client.to_json();
            assertTrue(json.contains("\"numclient\":1"));
            assertTrue(json.contains("\"nom\":\"Doe\""));
            assertTrue(json.contains("\"prenom\":\"John\""));
            assertTrue(json.contains("\"adresse\":\"123 Main St\""));
            assertTrue(json.contains("\"phone\":\"+212666778899\""));
            assertTrue(json.contains("\"email\":\"john.doe@email.com\""));
            assertTrue(json.contains("\"comptes\":[{"));
        }

        @Test
        public void testClientFromJson() {
            // Arrange
            String json = "{\"numclient\":1,\"nom\":\"Doe\",\"prenom\":\"John\"," +
                    "\"adresse\":\"123 Main St\",\"phone\":\"+212666778899\"," +
                    "\"email\":\"john.doe@email.com\",\"comptes\":[]}";
            Client client = new Client().fromjson(json);
            // Assert
            assertEquals(1, client.getNumclient());
            assertEquals("Doe", client.getNom());
            assertEquals("John", client.getPrenom());
            assertEquals("123 Main St", client.getAdresse());
            assertEquals("+212666778899", client.getPhone());
            assertEquals("john.doe@email.com", client.getEmail());
            assertNotNull(client.getComptes());
            assertTrue(client.getComptes().isEmpty());
    }
}
