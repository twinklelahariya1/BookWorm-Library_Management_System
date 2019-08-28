package com.finalassignment.bookworm.controller;

import com.finalassignment.bookworm.dto.AdminDto;
import com.finalassignment.bookworm.model.Admin;
import com.finalassignment.bookworm.service.impl.AdminServiceImpl;
import com.finalassignment.bookworm.validater.ValidationHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Controlling Addition and finding of admin and fetches from the database.
 */

@Slf4j
@RestController
public class AdminController {

    private final AdminServiceImpl adminService;

    private final ValidationHelper validationUtil;

    public AdminController(AdminServiceImpl adminService, ValidationHelper validationUtil) {
        this.adminService = adminService;
        this.validationUtil = validationUtil;
    }

    /**
     * The addAdmin route is used to take data from user and adding data to the database after performing validations.
     * @param adminDto
     * @return
     */
    @PostMapping("/bookworm/addAdmin")
    public ResponseEntity<AdminDto> addAdmin(@Valid @RequestBody AdminDto adminDto) {

        log.debug("Adding admin to the Library");
        AdminDto addAdmin = adminService.addAdmin(validationUtil.adminValidator(adminDto));
        return new ResponseEntity(addAdmin, new HttpHeaders(), HttpStatus.OK);

    }


    /**
     * Getting admin data from database by id of the admin
     * @param admin_id
     * @return
     */
    @GetMapping(value = "/bookworm/showAdminById/{admin_id}")
    public Admin showAdminById(@PathVariable Long admin_id) {

        log.debug("Getting Admin By Id.");
        return adminService.findById(admin_id);
    }

    /**
     * Getting all the data of admin form database.
     * @return
     */
    @GetMapping("/bookworm/showAllAdmins")
    public ResponseEntity<List> showAllAdmins() {

        log.debug("Showing all the admins of library");
        return ResponseEntity.ok(adminService.getAdmin());

    }
}
