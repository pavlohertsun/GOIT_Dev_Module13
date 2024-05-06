
package services;

import entities.Planet;
import repositories.PlanetRepository;
import utils.HibernateUtil;

import java.util.List;

public class PlanetService {
    private PlanetRepository planetRepository = new PlanetRepository(HibernateUtil.getInstance().getSessionFactory());

    public boolean createPlanet(Planet planet) {
        return planetRepository.createPlanet(planet);
    }

    public List<Planet> getAllPlanets(){
        return planetRepository.getAllPlanets();
    }

    public Planet getPlanetById(String id) {
        return planetRepository.getPlanetById(id);
    }

    public boolean updatePlanet(Planet planet) {
        return planetRepository.updatePlanet(planet);
    }

    public boolean deletePlanet(Planet planet) {
        return planetRepository.deletePlanet(planet);
    }
}
