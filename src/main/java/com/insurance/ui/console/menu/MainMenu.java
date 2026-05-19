package com.insurance.ui.console.menu;

import com.insurance.service.interfaces.ClientService;

import java.util.Scanner;

public class MainMenu {

    private final Scanner scanner;
    private final ClientService clientService;

    public MainMenu(ClientService clientService) {
        this.clientService = clientService;
        this.scanner = new Scanner(System.in);
    }

    public void start() {

        boolean running = true;

        while (running) {

            displayMenu();

            String choice = scanner.nextLine();

            switch (choice) {
                case "1" -> createClient();

                case "2" -> viewAllClient();

                case "3" -> findClientById();

                case "4" -> deleteClient();

                case "5" -> {
                    running = false;
                    System.out.println("Exiting system...");
                }

                default -> System.out.println("Invalid option");
            }

        }

    }

    private void displayMenu() {
        System.out.println("""
                ===== INSURANCE MANAGEMENT MENU ====
                
                1. Create Client
                2. View All Clients
                3. Find Client By ID
                4. Delete Client
                5. Exit
                
                Select option:
                """);
    }

    private void createClient() {}
    private void viewAllClient() {}
    private void findClientById() {}
    private void deleteClient() {}

}
