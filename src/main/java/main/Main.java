package main;

import entities.Client;
import entities.Planet;
import entities.Ticket;
import services.ClientService;
import services.PlanetService;
import services.TicketService;
import utils.MigrationExecutor;
import utils.PropertiesReader;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        MigrationExecutor.executeMigration(PropertiesReader.getDbConnectionUrl(),
                PropertiesReader.getDbUsername(), PropertiesReader.getDbPassword());

        testClientCruds();

        testPlanetCruds();

        testTicketCruds();
    }
    private static void testPlanetCruds(){
        PlanetService planetService = new PlanetService();

        planetService.getAllPlanets().forEach(System.out::println);

        Planet planet = new Planet("EARTH", "Earth");
        planetService.createPlanet(planet);

        System.out.println(planetService.getPlanetById("EARTH"));

        planet.setName("Earth_Updated");
        planetService.updatePlanet(planet);

        System.out.println(planetService.getPlanetById("EARTH"));

        planetService.deletePlanet(planet);

        planetService.getAllPlanets().forEach(System.out::println);
    }

    private static void testClientCruds(){
        ClientService clientService = new ClientService();

        clientService.getAllClients().forEach(System.out::println);

        Client client = new Client();
        client.setName("Test_Client");
        clientService.createClient(client);

        System.out.println(clientService.getClientById(15L));

        client.setName("Test_Client_Updated");
        clientService.updateClient(client);

        System.out.println(clientService.getClientById(15L));

        clientService.deleteClient(client);

        clientService.getAllClients().forEach(System.out::println);
    }

    private static void testTicketCruds(){
        TicketService ticketService = new TicketService();
        ClientService clientService = new ClientService();
        PlanetService planetService = new PlanetService();

        ticketService.getAllTickets().forEach(System.out::println);

        Ticket ticket = new Ticket();

        Client client = clientService.getClientById(1L);
        Planet fromPlanet = planetService.getPlanetById("MARS");
        Planet toPlanet = planetService.getPlanetById("VEN");

        ticket.setClient(client);
        ticket.setFromPlanet(fromPlanet);
        ticket.setToPlanet(toPlanet);

        ticketService.createTicket(ticket);

        System.out.println(ticketService.getTicketById(11L));

        ticket.setFromPlanet(toPlanet);
        ticket.setToPlanet(fromPlanet);
        ticketService.updateTicket(ticket);

        System.out.println(ticketService.getTicketById(11L));

        ticketService.deleteTicket(ticket);

        ticketService.getAllTickets().forEach(System.out::println);
    }
}