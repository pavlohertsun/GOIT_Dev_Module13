package repositories;

import entities.Planet;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import utils.HibernateUtil;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PlanetRepositoryTest {

    PlanetRepository planetRepository = new PlanetRepository(HibernateUtil.getInstance().getSessionFactory());
    @Test
    void getAllPlanetsTest() {
        List<Planet> expectedList = new ArrayList<>();

        expectedList.add(new Planet("MARS", "Mars"));
        expectedList.add(new Planet("VEN", "Venus"));
        expectedList.add(new Planet("MER", "Mercury"));
        expectedList.add(new Planet("JUP", "Jupiter"));
        expectedList.add(new Planet("SAT", "Saturn"));

        List<Planet> actualList = planetRepository.getAllPlanets();

        Assertions.assertIterableEquals(expectedList, actualList);
    }
    @Test
    void getPlanetByIdTest() {
        Planet expectedPlanet = new Planet("VEN","Venus");

        Planet actualPlanet = planetRepository.getPlanetById("VEN");

        Assertions.assertEquals(expectedPlanet, actualPlanet);
    }

    @Test
    void createPlanetTest() {
        Planet planetToAdd = new Planet("EARTH", "Earth");

        boolean expectedResult = true;

        boolean actualResult = planetRepository.createPlanet(planetToAdd);

        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    void updatePlanetTest() {
        Planet planetToUpdate = new Planet("EARTH", "Earth_Updated");

        boolean expectedResult = true;

        boolean actualResult = planetRepository.updatePlanet(planetToUpdate);

        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    void deletePlanetTest() {
        Planet planetToDelete = new Planet("EARTH", "Earth_Updated");

        boolean expectedResult = true;

        boolean actualResult = planetRepository.deletePlanet(planetToDelete);

        Assertions.assertEquals(expectedResult, actualResult);
    }
    @Test
    void createPlanetWithInvalidNameTest(){
        Planet planetToAdd = new Planet("EARTh", "Earth");

        boolean expectedResult = false;

        boolean actualResult = planetRepository.createPlanet(planetToAdd);

        Assertions.assertEquals(expectedResult, actualResult);
    }
}