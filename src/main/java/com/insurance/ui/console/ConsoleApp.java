package com.insurance.ui.console;

import com.insurance.repository.impl.FileClientRepository;
import com.insurance.repository.interfaces.ClientRepository;
import com.insurance.service.impl.ClientServiceImpl;
import com.insurance.service.interfaces.ClientService;
import com.insurance.ui.console.menu.MainMenu;

public class ConsoleApp {

    public static void main(String[] args) {

        ClientRepository clientRepository = new FileClientRepository();
        ClientService clientService = new ClientServiceImpl(clientRepository);

        MainMenu mainMenu = new MainMenu(clientService);

        mainMenu.start();
    }

}
