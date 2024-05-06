package repositories;

import entities.Client;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import repositories.interfaces.ClientCrudInterface;
import repositories.interfaces.utils.TransactionUtil;

import java.util.List;

public class ClientRepository implements ClientCrudInterface {
    private static final String GET_ALL_WORKER_SCRIPT= "from Client";
    private SessionFactory sessionFactory;
    public ClientRepository(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }
    @Override
    public List<Client> getAllClients() {
        try(Session session = sessionFactory.openSession()){
            return session.createQuery(GET_ALL_WORKER_SCRIPT, Client.class).list();
        }
    }

    @Override
    public Client getClientById(long id) {
        try(Session session = sessionFactory.openSession()){
            return session.get(Client.class, id);
        }
    }

    @Override
    public boolean createClient(Client client) {
        return TransactionUtil.performTransactionalOperation((session, c) -> {
            session.persist(c);
            return true;
        }, client, sessionFactory.openSession());
    }

    @Override
    public boolean updateClient(Client client) {
        return TransactionUtil.performTransactionalOperation((session, c) -> {
            session.merge(c);
            return true;
        }, client, sessionFactory.openSession());
    }

    @Override
    public boolean deleteClient(Client client) {
        return TransactionUtil.performTransactionalOperation((session, c) -> {
            session.remove(c);
            return true;
        }, client, sessionFactory.openSession());
    }
}