package com.finalassignment.bookworm.service.impl;

import com.finalassignment.bookworm.exception.AuthorNotFoundException;
import com.finalassignment.bookworm.model.Admin;
import com.finalassignment.bookworm.repository.AdminRepository;
import com.finalassignment.bookworm.service.AdminService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AdminServiceImpl implements AdminService {

    private final AdminRepository adminRepository;

    public AdminServiceImpl(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    @Override
    public Admin addAdmin(Admin admin) {
        admin = adminRepository.save(admin);
        return admin;
    }

    @Override
    public List<Admin> getAdmin() {
        return adminRepository.findAll();
    }

    @Override
    public Admin findById(Long adminId) {
        return adminRepository.findById(adminId).orElseThrow(() -> new AuthorNotFoundException(adminId));
    }
}
