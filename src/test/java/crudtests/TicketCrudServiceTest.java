package crudtests;

import org.example.crud.ClientCrudService;
import org.example.crud.PlanetCrudService;
import org.example.crud.TicketCrudService;
import org.example.entity.Client;
import org.example.entity.Planet;
import org.example.entity.Ticket;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

public class TicketCrudServiceTest {

    private static SessionFactory sessionFactory;
    private static TicketCrudService ticketCrudService;
    private static ClientCrudService clientCrudService;
    private static PlanetCrudService planetCrudService;

    @BeforeAll
    public static void setUp() {
        // Set up Hibernate SessionFactory
        sessionFactory = new Configuration().configure().buildSessionFactory();
        ticketCrudService = new TicketCrudService(sessionFactory);
        clientCrudService = new ClientCrudService(sessionFactory); // Initialize clientCrudService
        planetCrudService = new PlanetCrudService(sessionFactory); // Initialize planetCrudService
    }


    @AfterAll
    public static void cleanup() {
        // Close Hibernate SessionFactory
        ticketCrudService.close();
    }

    @Test
    public void testSaveAndGetTicket() {

        Client client = new Client("Erik Remark");

        Planet fromPlanet = new Planet("EXAMPLE", "Earth");
        Planet toPlanet = new Planet("EXAMPLETWO", "Mars");

        clientCrudService.saveClient(client);
        planetCrudService.savePlanet(fromPlanet);
        planetCrudService.savePlanet(toPlanet);

        Ticket ticket = new Ticket();
        ticket.setCreatedAt(LocalDateTime.now());
        ticket.setClient(client);
        ticket.setFromPlanet(fromPlanet);
        ticket.setToPlanet(toPlanet);

        Ticket savedTicket = ticketCrudService.saveTicket(ticket);

        Ticket retrievedTicket = ticketCrudService.getTicketById(savedTicket.getId());

        assertNotNull(retrievedTicket);
        assertEquals(savedTicket.getId(), retrievedTicket.getId());
        assertEquals(savedTicket.getCreatedAt(), retrievedTicket.getCreatedAt());
        assertEquals(savedTicket.getClient().getId(), retrievedTicket.getClient().getId());
        assertEquals(savedTicket.getFromPlanet().getId(), retrievedTicket.getFromPlanet().getId());
        assertEquals(savedTicket.getToPlanet().getId(), retrievedTicket.getToPlanet().getId());
    }

}
