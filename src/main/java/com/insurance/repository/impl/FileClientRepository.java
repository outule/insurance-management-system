package com.insurance.repository.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.insurance.config.AppConfig;
import com.insurance.model.Client;
import com.insurance.repository.interfaces.ClientRepository;
import com.insurance.util.JsonUtil;

import java.util.List;

public class FileClientRepository implements ClientRepository {

    private final String filePath;

    public FileClientRepository() {
        this.filePath = AppConfig.getClientsFilePath();
    }

    @Override
    public Client save(Client client) {
        if (client == null) {
            throw new IllegalArgumentException("client cannot be null");
        }

        List<Client> clients = findAll();

        clients.removeIf(existingClient ->
                client.getClientId() != null &&
                        existingClient.getClientId().equals(client.getClientId()));

        clients.add(client);

        JsonUtil.writeList(filePath, clients);

        return client;
    }

    @Override
    public Client findById(String id) {
        return findAll()
                .stream()
                .filter(client -> client.getClientId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Client> findAll() {
        return JsonUtil.readList(filePath, new TypeReference<>() {
        });
    }

    @Override
    public void delete(String id) {
        List<Client> clients = findAll();

        clients.removeIf(client -> client.getClientId().equals(id));

        JsonUtil.writeList(filePath, clients);
    }

    @Override
    public List<Client> findByName(String name) {
        return findAll()
                .stream()
                .filter(client ->
                        client.getFullName()
                                .toLowerCase()
                                .contains(name.toLowerCase()))
                .toList();
    }
}
