package com.finalassignment.bookworm.service;

import com.finalassignment.bookworm.dto.AdminDto;
import com.finalassignment.bookworm.model.Admin;

import java.util.List;

public interface AdminService {

    AdminDto addAdmin(AdminDto adminDto);
    List<Admin> getAdmin();
    Admin findById(Long adminId);
}
