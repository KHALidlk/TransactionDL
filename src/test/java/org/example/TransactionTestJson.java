package org.example;
import org.junit.jupiter.api.Test;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;
import com.google.gson.Gson;
import static org.junit.jupiter.api.Assertions.*;
    public class TransactionTestJson {
        @Test
        public void testTransactionToJson() {
            // Create test data
            Set<Compte> comptes = new HashSet<>();
            comptes.add(new Compte(1, null, null, "MAD", null, 1000.0, null, new HashSet<>()));
            comptes.add(new Compte(2, null, null, "EUR", null, 2000.0, null, new HashSet<>()));
            Transaction transaction = new Transaction(new Date(System.currentTimeMillis()), "REF123", comptes, Transaction.Type.VIRINT);
            // Convert to JSON
            String json = transaction.toJson();
            // Verify JSON contains expected values
            assertTrue(json.contains("\"reference\":\"REF123\""));
            assertTrue(json.contains("\"type1\":\"VIRINT\""));
            assertTrue(json.contains("\"comptes\":[{"));
        }

        @Test
        public void testTransactionFromJson() {
            // Create test JSON string
            String json = "{\"time\":\"2024-01-01\",\"reference\":\"REF123\",\"comptes\":[],\"type1\":\"VIRINT\"}";

            // Convert JSON to Transaction object
            Transaction transaction = Transaction.fromJson(json);

            // Verify deserialized object properties
            assertEquals("REF123", transaction.getReference());
            assertEquals(Transaction.Type.VIRINT, transaction.getType1());
            assertNotNull(transaction.getComptes());
            assertTrue(transaction.getComptes().isEmpty());
            assertEquals("2024-01-01", transaction.getTime().toString());
        }
    }
