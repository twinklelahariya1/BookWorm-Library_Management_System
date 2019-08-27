package com.finalassignment.bookworm.service.impl;

import com.finalassignment.bookworm.dto.AdminDto;
import com.finalassignment.bookworm.exception.AdminNotFoundException;
import com.finalassignment.bookworm.exception.AuthorNotFoundException;
import com.finalassignment.bookworm.model.Admin;
import com.finalassignment.bookworm.repository.AdminRepository;
import com.finalassignment.bookworm.service.AdminService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;


@Service
public class AdminServiceImpl implements AdminService {

    private final AdminRepository adminRepository;

    public AdminServiceImpl(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    private static AdminDto fromAdmin(final Admin admin) {

        AdminDto adminDto = new AdminDto();
        adminDto.setAdminId(admin.getAdminId());
        adminDto.setAdminName(admin.getAdminName());
        adminDto.setAdminContactNumber(admin.getAdminContactNumber());
        adminDto.setAdminEmail(admin.getAdminEmail());
        adminDto.setAdminPassword(admin.getAdminPassword());

        return adminDto;
    }

    private static Admin fromAdminDto(final AdminDto adminDto) {

        Admin admin = new Admin();
        admin.setAdminId(adminDto.getAdminId());
        admin.setAdminName(adminDto.getAdminName());
        admin.setAdminContactNumber(adminDto.getAdminContactNumber());
        admin.setAdminEmail(adminDto.getAdminEmail());
        admin.setAdminPassword(adminDto.getAdminPassword());

        return admin;
    }

    @Override
    public AdminDto addAdmin(AdminDto adminDto) {
        Admin admin = adminRepository.save(fromAdminDto(adminDto));
        return adminDto;
    }

    @Override
    public List<AdminDto> getAdmin() {
        List<Admin> admins = adminRepository.findAll();
        List<AdminDto> adminDtos = null;
        if(!CollectionUtils.isEmpty(admins)){
            adminDtos = new ArrayList<>();
            for (Admin admin : admins) {
                AdminDto adminDto = fromAdmin(admin);
                adminDtos.add(adminDto);
            }
        }
        return adminDtos;
    }

    @Override
    public AdminDto findById(Long adminId) {

        Admin admin=adminRepository.findById(adminId).orElseThrow(()->new  AdminNotFoundException(adminId));
        AdminDto adminDto=fromAdmin(admin);
        return adminDto;
    }
}
