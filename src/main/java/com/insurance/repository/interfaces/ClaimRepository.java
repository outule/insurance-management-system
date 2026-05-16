package com.insurance.repository.interfaces;

import com.insurance.model.Claim;
import com.insurance.model.Policy;

import java.util.List;

public interface ClaimRepository extends BaseRepository<Claim> {
    List<Policy> findPolicyById(String policyId);
}
