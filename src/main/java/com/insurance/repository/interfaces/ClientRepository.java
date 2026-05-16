package com.insurance.repository.interfaces;

import com.insurance.model.Client;

import java.util.List;

public interface ClientRepository extends BaseRepository<Client> {
    List<Client> findByName(String name);
}
