package com.insurance.ui.console;

import com.insurance.model.Client;
import com.insurance.repository.impl.FileClientRepository;
import com.insurance.repository.interfaces.ClientRepository;
import com.insurance.service.impl.ClientServiceImpl;
import com.insurance.service.interfaces.ClientService;

public class MainApp {

    public static void main(String[] args) {
        ClientRepository clientRepository = new FileClientRepository();
        ClientService clientService = new ClientServiceImpl(clientRepository);

        Client client = new Client();

        client.setFullName("Outule Mosweu");
        client.setEmail("outulemosweu2903@gmail.com");
        client.setPhone("77072610");
        client.setAddress("Gaborone");

        clientService.create(client);

        System.out.println(clientService.findAll());
    }

}
