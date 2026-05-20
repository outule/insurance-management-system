package com.insurance.ui.console.menu;

import com.insurance.model.Client;
import com.insurance.service.interfaces.ClientService;

import java.util.List;
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
        System.out.print("""
                
                 ===== INSURANCE MANAGEMENT MENU ====
                \s
                 1. Create Client
                 2. View All Clients
                 3. Find Client By ID
                 4. Delete Client
                 5. Exit
                \s
                 Select option:\s""");
    }

    private void createClient() {
        try {
            System.out.print("Enter full name: ");
            String fullName = scanner.nextLine();

            System.out.print("Enter email: ");
            String email = scanner.nextLine();

            System.out.print("Enter phone: ");
            String phone = scanner.nextLine();

            System.out.print("Enter address: ");
            String address = scanner.nextLine();

            Client client = new Client();

            client.setFullName(fullName);
            client.setEmail(email);
            client.setPhone(phone);
            client.setAddress(address);

            clientService.create(client);

            System.out.println("Client created successfully!");
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }

    private void viewAllClient() {
        try {
            List<Client> clients = clientService.findAll();

            if (clients.isEmpty()) {
                System.out.println("No client found.");
                return;
            }

            System.out.println("==== CLIENT LIST ====");

            for (Client client : clients) {
                System.out.println(client);
            }
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }

    private void findClientById() {
        try {
            System.out.print("Enter Client ID: ");
            String id = scanner.nextLine();

            Client client = clientService.findById(id);

            if (client == null) {
                System.out.println("Client with ID: " + id + " not found.");
                return;
            }

            System.out.println(client);
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }

    private void deleteClient() {
        try {
            System.out.print("Enter Client ID:");
            String id = scanner.nextLine();

            System.out.println("Are you sure? (Y/N)");
            char answer = scanner.next().toUpperCase().charAt(0);
            scanner.nextLine();

            if (answer == 'Y') {
                System.out.println("Client with ID: " + id + " deleted successfully!");
                clientService.delete(id);
            } else if (answer == 'N') {
                System.out.println("Client not deleted");
            } else  {
                System.out.println("Invalid input!");
            }
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }

}