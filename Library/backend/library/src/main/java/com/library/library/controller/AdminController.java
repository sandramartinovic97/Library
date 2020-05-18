package com.library.library.controller;

import com.library.library.dto.AdminDto;
import com.library.library.model.Admin;
import com.library.library.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping
    public List<Admin> getAdmins() {
        return adminService.getAdmins();
    }

    @GetMapping("/{id}")
    public Admin getAdminById(@PathVariable("id") Integer id) {
        return adminService.getAdminById(id);
    }

    @PostMapping
    public AdminDto createAdmin(@RequestBody AdminDto adminDto) {
        return adminService.createAdmin(adminDto);
    }

    @PutMapping("/{id}")
    public AdminDto updateAdmin(@PathVariable("id") Integer id,@RequestBody AdminDto adminDto) {
        return adminService.updateAdmin(id, adminDto);
    }

    @DeleteMapping("/{id}")
    public void deleteAdmin(@PathVariable("id") Integer id) {
        adminService.deleteAdmin(id);
    }
}