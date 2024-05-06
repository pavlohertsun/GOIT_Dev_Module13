package repositories;

import entities.Client;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import utils.HibernateUtil;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ClientRepositoryTest {
    ClientRepository clientRepository = new ClientRepository(HibernateUtil.getInstance().getSessionFactory());
    @Test
    void getAllClientsTest() {
        List<Client> expectedList = new ArrayList<>();

        expectedList.add(new Client(1, "John"));
        expectedList.add(new Client(2, "Emily"));
        expectedList.add(new Client(3, "Helen"));
        expectedList.add(new Client(4, "Paul"));
        expectedList.add(new Client(5, "Andrew"));
        expectedList.add(new Client(6, "James"));
        expectedList.add(new Client(7, "Robert"));
        expectedList.add(new Client(8, "Michael"));
        expectedList.add(new Client(9, "David"));
        expectedList.add(new Client(10, "William"));

        List<Client> actualList = clientRepository.getAllClients();

        Assertions.assertIterableEquals(expectedList, actualList);
    }

    @Test
    void getClientByIdTest() {
        Client expectedClient = new Client(4, "Paul");

        Client actualClient = clientRepository.getClientById(4);

        Assertions.assertEquals(expectedClient, actualClient);
    }

    @Test
    void createClientTest() {
        Client clientToAdd = new Client();
        clientToAdd.setName("test_client");

        boolean expectedResult = true;

        boolean actualResult = clientRepository.createClient(clientToAdd);

        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    void updateClientTest() {
        Client clientToUpdate = new Client(11, "test_client_updated");

        boolean expectedResult = true;

        boolean actualResult = clientRepository.updateClient(clientToUpdate);

        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    void deleteClientTest() {
        Client clientToDelete = new Client(11, "test_client_updated");

        boolean expectedResult = true;

        boolean actualResult = clientRepository.deleteClient(clientToDelete);

        Assertions.assertEquals(expectedResult, actualResult);
    }
    @Test
    void createClientWithInvalidNameTest(){
        Client clientToAdd = new Client();
        clientToAdd.setName("cl");

        boolean expectedResult = false;

        boolean actualResult = clientRepository.createClient(clientToAdd);

        Assertions.assertEquals(expectedResult, actualResult);
    }
}