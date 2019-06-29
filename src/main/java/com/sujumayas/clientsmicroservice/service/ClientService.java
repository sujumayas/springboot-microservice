package com.sujumayas.clientsmicroservice.service;

import com.sujumayas.clientsmicroservice.model.Client;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

/**
 * Client Service
 */
@Service
public class ClientService {

    /** TODO : All this should be in DB later :D */
    private List<Client> clients = new ArrayList<>(Arrays.asList(
            new Client("123", "Esen", "Espinosa", "32", "24/10/1986"),
            new Client("124", "Mariana", "Hernandez", "32", "15/01/1987")
    ));
    private Double clientsAverageAge;
    private Number clientListSize = 2;
    private List<String> clientAges;

    
    /**
     * Get All Clients
     * 
     * @return List<Client>
     */
    public List<Client> getAllClients(){
        return clients;
    }
    
    /**
     * Get Single Client
     * 
     * @return Client
     */
    public Client getClient(String id){
        return clients.stream().filter(client -> client.getId().equals(id)).findFirst().get();
    }
    
    /**
     * Create Client
     * 
     * TODO : Set requeriments on the attributes we want to be required and check
     * for unique ids
     * 
     * @return void
     */
    public void createClient(Client client){
        clients.add(client);
    }
    
    /**
     * Update Client
     * 
     * TODO: Restrict option to change ID TODO: Do not replace empty keys
     * 
     * @return void
     */
    public void updateClient(Client client, String id) {
        for (int i = 0; i < clients.size(); i++) {
            Client c = clients.get(i);
            if(c.getId().equals(id)){
                clients.set(i, client);
                return;
            }
        }
    }
    
    /**
     * Delete Client
     * 
     * @return void
     */
    public void deleteClient(String id) {
        clients.removeIf(client-> client.getId().equals(id)); 
    }
    


    /*
     ******************************
     * ---------------------------* 
     *  CLIENT SERVICE UTILITIES  *
     * ---------------------------*
     ******************************
    */
    /**
     * Get Clients Average Age
     * 
     * @return
     */
    public Number getClientsAverageAge(){
        updateClientsAverageAge(); //TODO: Move this updateAverage to a CronJob or an EventCalled (onClientCreation) method
        return clientsAverageAge;
    }
    
    /**
     * Update Clients Average Age Cached value
     * 
     * Programmer disclaimer: This method was done before Extract Ages into array, 
     * so... it uses original List of clients instead of the curated list of Ages. 
     * This is a rushing project. 
     * 
     * TODO: Refactor this mathod to use curated list of client ages
     * 
     * @return
     */
    public void updateClientsAverageAge(){
        clientListSize = clients.size(); 
        double newAgeSum = clients.stream().mapToDouble(i -> Double.parseDouble(i.getAge())).sum(); /** TODO: Learn more about java 8 lamdas <3 */
        clientsAverageAge = newAgeSum / (double) clientListSize;
    }
    
    /**
     * Extract Ages into Array
     * 
     * @return
     */
    public void extractAges() {
        clientAges = new ArrayList<>();
        for(int i = 0; i < clients.size(); i++){
            Client c = clients.get(i);
            clientAges.add(c.getAge());
        }
    }
}