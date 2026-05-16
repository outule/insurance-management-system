package com.insurance.ui.console;

import com.insurance.repository.impl.FileClientRepository;
import com.insurance.repository.interfaces.ClientRepository;

public class MainApp {

    public static void main(String[] args) {
        ClientRepository clientRepository = new FileClientRepository();
        System.out.println(clientRepository.findAll());
    }

}
