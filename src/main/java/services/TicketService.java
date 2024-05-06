package services;

import entities.Ticket;
import repositories.TicketRepository;
import utils.HibernateUtil;

import java.util.List;

public class TicketService {
    private TicketRepository ticketRepository = new TicketRepository(HibernateUtil.getInstance().getSessionFactory());

    public boolean createTicket(Ticket ticket) {
        return ticketRepository.createTicket(ticket);
    }

    public List<Ticket> getAllTickets(){
        return ticketRepository.getAllTickets();
    }

    public Ticket getTicketById(Long id) {
        return ticketRepository.getTicketById(id);
    }

    public boolean updateTicket(Ticket ticket) {
        return ticketRepository.updateTicket(ticket);
    }

    public boolean deleteTicket(Ticket ticket) {
        return ticketRepository.deleteTicket(ticket);
    }
}