package com.insurance.service.impl;

import com.insurance.model.Client;
import com.insurance.repository.interfaces.ClientRepository;
import com.insurance.service.interfaces.ClientService;
import com.insurance.util.IdGenerator;
import com.insurance.util.StatusConstants;

import java.time.LocalDate;
import java.util.List;

public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;

    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public Client create(Client client) {
        if (client == null) {
            throw new IllegalArgumentException("Client cannot be null");
        }

        client.setFullName(client.getFullName().trim());
        client.setEmail(client.getEmail().trim());
        client.setPhone(client.getPhone().trim());
        client.setAddress(client.getAddress().trim());

        validateClient(client);

        client.setClientId(IdGenerator.generateId());
        client.setDateCreated(LocalDate.now());
        client.setStatus(StatusConstants.ACTIVE);

        boolean emailExist = clientRepository.findAll()
                .stream()
                .anyMatch(existingClient ->
                        existingClient.getEmail()
                                .equalsIgnoreCase(client.getEmail()));

        if (emailExist) {
            throw new IllegalArgumentException("Email already exists");
        }

        return clientRepository.save(client);
    }

    @Override
    public Client findById(String id) {
        if (id == null || !id.isBlank()) {
            throw new IllegalArgumentException("Client ID cannot be empty");
        }

        return clientRepository.findById(id);
    }

    @Override
    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    @Override
    public void delete(String id) {
        if (id == null || !id.isBlank()) {
            throw new IllegalArgumentException("Client ID cannot be empty");
        }

        clientRepository.delete(id);
    }

    /*
        Validating Clients information before persistence.
     */
    private void validateClient(Client client) {
        validateFullName(client.getFullName());
        validateEmail(client.getEmail());
        validatePhone(client.getPhone());
    }

    private void validateFullName(String fullName) {
        if (fullName == null || fullName.isEmpty()) {
            throw new IllegalArgumentException("Full name is required");
        }
    }

    /**
     * Validates email format using regex.
     */
    private void validateEmail(String email) {
        String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";

        if (email == null || !email.matches(emailRegex)) {
            throw new IllegalArgumentException("Invalid email format");
        }
    }

    private void validatePhone(String phone) {
        if (phone == null || phone.isEmpty()) {
            throw new IllegalArgumentException("Phone number is required");
        }
    }
}
