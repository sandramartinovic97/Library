package com.library.library.service;

import com.library.library.dto.AdminDto;
import com.library.library.model.Admin;

import java.util.List;

public interface AdminService {
    List<Admin> getAdmins();
    Admin getAdminById(Integer id);
    AdminDto createAdmin(AdminDto adminDto);
    AdminDto updateAdmin(Integer id, AdminDto adminDto);
    void deleteAdmin(Integer id);
}