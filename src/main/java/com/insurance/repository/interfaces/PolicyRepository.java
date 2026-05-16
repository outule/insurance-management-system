package com.insurance.repository.interfaces;

import com.insurance.model.Policy;

import java.util.List;

public interface PolicyRepository extends BaseRepository<Policy> {
    List<Policy> findByClientId(String clientId);
}
