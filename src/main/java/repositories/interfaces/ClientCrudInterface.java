package repositories.interfaces;

import entities.Client;

import java.util.List;

public interface ClientCrudInterface {
    List<Client> getAllClients();
    Client getClientById(long id);
    boolean createClient(Client client);
    boolean updateClient(Client client);
    boolean deleteClient(Client client);
}
