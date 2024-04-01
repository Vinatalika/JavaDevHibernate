package crudtests;

import org.example.crud.PlanetCrudService;
import org.example.entity.Planet;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

public class PlanetCrudServiceTest {

    private static PlanetCrudService planetService;
    private static SessionFactory sessionFactory;

    @BeforeAll
    public static void setup() {
        Configuration configuration = new Configuration().configure();
        sessionFactory = configuration.buildSessionFactory();
        planetService = new PlanetCrudService(sessionFactory);
    }

    @AfterAll
    public static void cleanup() {
        // Close the planet service before closing the session factory
        if (planetService != null) {
            planetService.close();
        }
        if (sessionFactory != null) {
            sessionFactory.close();
        }
    }

    @Test
    public void testPlanetCRUD() {
        // Create a planet
        Planet planet = new Planet("NEWEARTH", "NEWEarth");

        // Use try-catch to handle the unique constraint violation
        try {
            planetService.savePlanet(planet);
        } catch (Exception e) {
            // If the planet already exists, retrieve the existing one
            planet = planetService.getPlanetById("NEWEARTH");
        }

        String planetId = planet.getId();

        // Retrieve the planet
        Planet retrievedPlanet = planetService.getPlanetById(planetId);
        assertNotNull(retrievedPlanet);
        assertEquals("NEWEARTH", retrievedPlanet.getId());
        assertEquals("NEWEarth", retrievedPlanet.getName());

        // Update the planet
        retrievedPlanet.setName("New Earth");
        planetService.updatePlanet(retrievedPlanet);

        // Check if the planet was updated
        Planet updatedPlanet = planetService.getPlanetById(planetId);
        assertNotNull(updatedPlanet);
        assertEquals("NEWEARTH", updatedPlanet.getId()); // Update the expected ID to match the initial one
        assertEquals("New Earth", updatedPlanet.getName());

        // Delete the planet
        planetService.deletePlanet(planetId);

        // Ensure the planet is deleted
        assertNull(planetService.getPlanetById(planetId));
    }
}