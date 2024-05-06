package repositories;

import entities.Planet;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import repositories.interfaces.PlanetCrudInterface;
import repositories.interfaces.utils.TransactionUtil;

import java.util.List;


public class PlanetRepository implements PlanetCrudInterface {
    private static final String GET_ALL_WORKER_SCRIPT= "from Planet";
    private SessionFactory sessionFactory;
    public PlanetRepository(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }
    @Override
    public List<Planet> getAllPlanets() {
        try(Session session = sessionFactory.openSession()){
            return session.createQuery(GET_ALL_WORKER_SCRIPT, Planet.class).list();
        }
    }

    @Override
    public Planet getPlanetById(String id) {
        try(Session session = sessionFactory.openSession()){
            return session.get(Planet.class, id);
        }
    }

    @Override
    public boolean createPlanet(Planet planet) {
        return TransactionUtil.performTransactionalOperation((session, p) -> {
            session.persist(p);
            return true;
        }, planet, sessionFactory.openSession());
    }

    @Override
    public boolean updatePlanet(Planet planet) {
        return TransactionUtil.performTransactionalOperation((session, p) -> {
            session.merge(p);
            return true;
        }, planet, sessionFactory.openSession());
    }

    @Override
    public boolean deletePlanet(Planet planet) {
        return TransactionUtil.performTransactionalOperation((session, p) -> {
            session.remove(p);
            return true;
        }, planet, sessionFactory.openSession());
    }
}
