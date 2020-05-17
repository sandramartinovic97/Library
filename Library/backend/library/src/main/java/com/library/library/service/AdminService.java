package com.library.library.service;

import com.library.library.model.Admin;

import java.util.List;

public interface AdminService {
    List<Admin> getAdmins();
    Admin getAdminById(Integer id);
    Admin createAdmin(Admin admin);
    Admin updateAdmin(Integer id, Admin admin);
    void deleteAdmin(Integer id);
}