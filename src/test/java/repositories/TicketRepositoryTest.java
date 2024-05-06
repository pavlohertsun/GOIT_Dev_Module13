package repositories;

import entities.Client;
import entities.Planet;
import entities.Ticket;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import utils.HibernateUtil;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TicketRepositoryTest {
    TicketRepository ticketRepository = new TicketRepository(HibernateUtil.getInstance().getSessionFactory());

    @Test
    void getAllTicketsTest() {
        List<Ticket> expectedList = new ArrayList<>();

        expectedList.add(new Ticket(1, Timestamp.valueOf("2024-05-06 15:48:22.649253"), new Client(1, "John"), new Planet("MARS", "Mars"), new Planet("VEN", "Venus")));
        expectedList.add(new Ticket(2, Timestamp.valueOf("2024-05-06 15:48:22.649253"), new Client(2, "Emily"), new Planet("MER", "Mercury"), new Planet("JUP", "Jupiter")));
        expectedList.add(new Ticket(3, Timestamp.valueOf("2024-05-06 15:48:22.649253"), new Client(3, "Helen"), new Planet("VEN", "Venus"), new Planet("MARS", "Mars")));
        expectedList.add(new Ticket(4, Timestamp.valueOf("2024-05-06 15:48:22.649253"), new Client(4, "Paul"), new Planet("SAT", "Saturn"), new Planet("MARS", "Mars")));
        expectedList.add(new Ticket(5, Timestamp.valueOf("2024-05-06 15:48:22.649253"), new Client(5, "Andrew"), new Planet("MARS", "Mars"), new Planet("JUP", "Jupiter")));
        expectedList.add(new Ticket(6, Timestamp.valueOf("2024-05-06 15:48:22.649253"), new Client(6, "James"), new Planet("MER", "Mercury"), new Planet("SAT", "Saturn")));
        expectedList.add(new Ticket(7, Timestamp.valueOf("2024-05-06 15:48:22.649253"), new Client(7, "Robert"), new Planet("JUP", "Jupiter"), new Planet("MER", "Mercury")));
        expectedList.add(new Ticket(8, Timestamp.valueOf("2024-05-06 15:48:22.649253"), new Client(8, "Michael"), new Planet("MARS", "Mars"), new Planet("VEN", "Venus")));
        expectedList.add(new Ticket(9, Timestamp.valueOf("2024-05-06 15:48:22.649253"), new Client(9, "David"), new Planet("MARS", "Mars"), new Planet("VEN", "Venus")));
        expectedList.add(new Ticket(10, Timestamp.valueOf("2024-05-06 15:48:22.649253"), new Client(10, "William"), new Planet("MARS", "Mars"), new Planet("JUP", "Jupiter")));

        List<Ticket> actualList = ticketRepository.getAllTickets();

        Assertions.assertIterableEquals(expectedList, actualList);
    }

    @Test
    void getTicketByIdTest() {
        Ticket expectedTicket = new Ticket(5, Timestamp.valueOf("2024-05-06 15:48:22.649253"), new Client(5, "Andrew"), new Planet("MARS", "Mars"), new Planet("JUP", "Jupiter"));

        Ticket actualTicket = ticketRepository.getTicketById(5L);
    }

    @Test
    void createTicketTest() {
        Ticket ticketToCreate = new Ticket();

        ticketToCreate.setClient(new Client(1, "John"));
        ticketToCreate.setFromPlanet(new Planet("MARS", "Mars"));
        ticketToCreate.setToPlanet(new Planet("JUP", "Jupiter"));

        boolean expectedResult = true;

        boolean actualResult = ticketRepository.createTicket(ticketToCreate);

        Assertions.assertEquals(expectedResult, actualResult);

    }

    @Test
    void updateTicketTest() {
        Ticket ticketToUpdate = ticketRepository.getTicketById(12L);

        ticketToUpdate.setToPlanet(new Planet("MARS", "Mars"));
        ticketToUpdate.setFromPlanet(new Planet("JUP", "Jupiter"));

        boolean expectedResult = true;

        boolean actualResult = ticketRepository.updateTicket(ticketToUpdate);

        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    void deleteTicketTest() {
        Ticket ticketToDelete = ticketRepository.getTicketById(12L);

        boolean expectedResult = true;

        boolean actualResult = ticketRepository.deleteTicket(ticketToDelete);

        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    void createTicketWithClientNullTest() {
        Ticket ticketToCreate = new Ticket();

        ticketToCreate.setToPlanet(new Planet("MARS", "Mars"));
        ticketToCreate.setFromPlanet(new Planet("JUP", "Jupiter"));

        boolean expectedResult = false;

        boolean actualResult = ticketRepository.createTicket(ticketToCreate);

        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    void createTicketWithNullPlanet(){
        Ticket ticketToCreate = new Ticket();

        ticketToCreate.setClient(new Client(1, "John"));
        ticketToCreate.setFromPlanet(new Planet("JUP", "Jupiter"));

        boolean expectedResult = false;

        boolean actualResult = ticketRepository.createTicket(ticketToCreate);

        Assertions.assertEquals(expectedResult, actualResult);
    }
}