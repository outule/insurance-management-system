package com.insurance.repository.interfaces;

import com.insurance.model.Payment;

import java.util.List;

public interface PaymentRepository extends BaseRepository<Payment>{
    List<Payment> findClientById(String clientId);
}
