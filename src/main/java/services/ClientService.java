package services;

import entities.Client;
import repositories.ClientRepository;
import utils.HibernateUtil;

import java.util.List;

public class ClientService {
    private ClientRepository clientRepository = new ClientRepository(HibernateUtil.getInstance().getSessionFactory());

    public boolean createClient(Client client) {
        return clientRepository.createClient(client);
    }

    public List<Client> getAllClients(){
        return clientRepository.getAllClients();
    }

    public Client getClientById(Long id) {
        return clientRepository.getClientById(id);
    }

    public boolean updateClient(Client client) {
        return clientRepository.updateClient(client);
    }

    public boolean deleteClient(Client client) {
        return clientRepository.deleteClient(client);
    }
}