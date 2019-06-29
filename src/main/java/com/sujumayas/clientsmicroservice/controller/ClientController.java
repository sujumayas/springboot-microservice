package com.sujumayas.clientsmicroservice.controller;

import com.sujumayas.clientsmicroservice.model.Client;
import com.sujumayas.clientsmicroservice.service.ClientService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClientController
 */
@RestController
@RequestMapping("/api/v1")
public class ClientController {

    @Autowired
    private ClientService clientService;

    /**
     * Get All Clients
     * 
     * Shows all clients
     * 
     * @return List<Client> toJSON
     */
    @RequestMapping("clients/list")
    public List<Client> getAllClients(){
        return clientService.getAllClients(); 
    }

    /**
     * Get a single Client
     * 
     * Shows a Client
     * 
     * @return Client toJSON
     */
    @RequestMapping("clients/{id}")
    public Client getClient(@PathVariable String id){
        return clientService.getClient(id);
    }

    /**
     * Get KPIS 
     * 
     * Shows KPIs: Average Age and Standard deviation 
     * 
     * @return String 
     */
    @RequestMapping("clients/kpis")
    public String getKPIs() {
        Number average = clientService.getClientsAverageAge();
        Number standardDeviation = 0;
        return "Average: " + average + "Standard Deviation: " + standardDeviation;
    }
    
    /**
     * Create Client
     * 
     * POST Method that lets you create a client
     * 
     * @return void
     */
    @RequestMapping(method=RequestMethod.POST, value="clients/create")
    public void createClient(@RequestBody Client client){
        clientService.createClient(client);
    }
    
    /**
     * Update a Client
     * 
     * PUT Method that lets you update a client by id
     * 
     * @return void
     */
    @RequestMapping(method = RequestMethod.PUT, value = "clients/update/{id}")
    public void updateClient(@RequestBody Client client, @PathVariable String id) {
        clientService.updateClient(client, id);
    }

    /**
     * Delete a Client
     * 
     * DELETE Method that lets you delete a client by id
     * 
     * @return void
     */
    @RequestMapping(method = RequestMethod.DELETE, value = "clients/delete/{id}")
    public void deleteClient(@PathVariable String id) {
        clientService.deleteClient(id);
    }
   
}