package com.insurance.model;

import java.time.LocalDate;

public class Client {
    private String clientId;
    private String fullName;
    private String email;
    private String phone;
    private String address;
    private LocalDate dateCreated;
    private String status;

    public Client() {}

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDate getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDate dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return """
                
                Client Information
                ------------------
                ID: %s
                Name: %s
                Email: %s
                Phone: %s
                Address: %s
                Status: %s
                Date Created: %s
                """
                .formatted(clientId, fullName, email, phone, address, status, dateCreated);
    }
}
