package repositories;

import entities.Ticket;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import repositories.interfaces.TicketCrudInterface;
import repositories.interfaces.utils.TransactionUtil;

import java.util.List;


public class TicketRepository implements TicketCrudInterface {
    private static final String GET_ALL_TICKETS_SCRIPT = "from Ticket";
    private SessionFactory sessionFactory;
    public TicketRepository(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }
    @Override
    public List<Ticket> getAllTickets() {
        try(Session session = sessionFactory.openSession()){
            return session.createQuery(GET_ALL_TICKETS_SCRIPT, Ticket.class).list();
        }
    }

    @Override
    public Ticket getTicketById(long id) {
        try(Session session = sessionFactory.openSession()){
            return session.get(Ticket.class, id);
        }
    }

    @Override
    public boolean createTicket(Ticket Ticket) {
        return TransactionUtil.performTransactionalOperation((session, p) -> {
            session.persist(p);
            return true;
        }, Ticket, sessionFactory.openSession());
    }

    @Override
    public boolean updateTicket(Ticket ticket) {
        return TransactionUtil.performTransactionalOperation((session, p) -> {
            session.merge(p);
            return true;
        }, ticket, sessionFactory.openSession());
    }

    @Override
    public boolean deleteTicket(Ticket ticket) {
        return TransactionUtil.performTransactionalOperation((session, p) -> {
            session.remove(p);
            return true;
        }, ticket, sessionFactory.openSession());
    }
}
