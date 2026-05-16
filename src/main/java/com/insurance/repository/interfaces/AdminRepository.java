package com.insurance.repository.interfaces;

import com.insurance.model.Admin;

public interface AdminRepository extends BaseRepository<Admin>{
    Admin findByUsername(String username);
}
