package repositories.interfaces;

import entities.Ticket;

import java.util.List;

public interface TicketCrudInterface {
    List<Ticket> getAllTickets();
    Ticket getTicketById(long id);
    boolean createTicket(Ticket ticket);
    boolean updateTicket(Ticket ticket);
    boolean deleteTicket(Ticket ticket);
}
