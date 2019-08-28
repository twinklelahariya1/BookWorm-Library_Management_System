package com.finalassignment.bookworm.controller;

import com.finalassignment.bookworm.dto.AdminDto;
import com.finalassignment.bookworm.model.Admin;
import com.finalassignment.bookworm.service.impl.AdminServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
public class AdminController {

    private final AdminServiceImpl adminService;

    public AdminController(AdminServiceImpl adminService) {
        this.adminService = adminService;
    }

    @PostMapping("/bookworm/addAdmin")
    public ResponseEntity<AdminDto> addAdmin(@Valid @RequestBody AdminDto adminDto) {

        log.debug("Adding admin to the Library");
        AdminDto addAdmin = adminService.addAdmin(adminDto);
        return new ResponseEntity(addAdmin, new HttpHeaders(), HttpStatus.OK);

    }


    @GetMapping(value = "/bookworm/showAdminById/{admin_id}")
    public Admin showAdminById(@PathVariable Long admin_id) {

        log.debug("Getting Admin By Id.");
        return adminService.findById(admin_id);
    }

    @GetMapping("/bookworm/showAllAdmins")
    public ResponseEntity<List> showAllAdmins() {

        log.debug("Showing all the admins of library");
        return ResponseEntity.ok(adminService.getAdmin());

    }
}
