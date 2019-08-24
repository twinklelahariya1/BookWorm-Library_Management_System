package com.finalassignment.bookworm.service;

import com.finalassignment.bookworm.model.Admin;

import java.util.List;

public interface AdminService {

    Admin addAdmin(Admin admin);
    List<Admin> getAdmin();
    Admin findById(Long adminId);
}
