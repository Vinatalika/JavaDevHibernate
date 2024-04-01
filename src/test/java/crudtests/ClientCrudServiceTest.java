package crudtests;

import org.example.entity.Client;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.example.crud.ClientCrudService;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

public class ClientCrudServiceTest {

    private static ClientCrudService clientService;
    private static SessionFactory sessionFactory;

    @BeforeAll
    public static void setup() {
        Configuration configuration = new Configuration().configure();
        sessionFactory = configuration.buildSessionFactory();
        clientService = new ClientCrudService(sessionFactory);
    }
    @AfterAll
    public static void cleanup() {
        // Close the planet service before closing the session factory
        if (clientService != null) {
            clientService.close();
        }
        if (sessionFactory != null) {
            sessionFactory.close();
        }
    }
    @Test
    public void testClientCRUD() {
        // Create a client
        Client client = new Client("John Doe");
        clientService.saveClient(client);
        Long clientId = client.getId();

        // Retrieve the client
        Client retrievedClient = clientService.getClientById(clientId);
        assertNotNull(retrievedClient);
        assertEquals("John Doe", retrievedClient.getName());

        // Update the client
        retrievedClient.setName("Jane Doe");
        clientService.updateClient(retrievedClient);

        // Check if the client was updated
        Client updatedClient = clientService.getClientById(clientId);
        assertNotNull(updatedClient);
        assertEquals("Jane Doe", updatedClient.getName());

        // Delete the client
        clientService.deleteClient(clientId);

        // Ensure the client is deleted
        assertNull(clientService.getClientById(clientId));
    }
}