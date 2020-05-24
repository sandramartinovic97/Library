package com.library.library.controller;

import com.library.library.dto.AdminDto;
import com.library.library.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "http://localhost:4200")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping
    public List<AdminDto> getAdmins() {
        return adminService.getAdmins();
    }

    @GetMapping("/{id}")
    public AdminDto getAdminById(@PathVariable("id") Integer id) {
        return adminService.getAdminById(id);
    }

    @PostMapping
    public ResponseEntity<String> createAdmin(@RequestBody AdminDto adminDto) {
        adminService.createAdmin(adminDto);
        return ResponseEntity.status(HttpStatus.OK).body("New admin is created.");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateAdmin(@PathVariable("id") Integer id,@RequestBody AdminDto adminDto) {
        adminService.updateAdmin(id, adminDto);
        return ResponseEntity.status(HttpStatus.OK).body("Admin with id=" + id + " is updated.");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAdmin(@PathVariable("id") Integer id) {
        adminService.deleteAdmin(id);
        return ResponseEntity.status(HttpStatus.OK).body("Admin with id=" + id + " is deleted.");
    }
}