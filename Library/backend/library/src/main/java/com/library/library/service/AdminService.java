package com.library.library.service;

import com.library.library.dto.AdminDto;

import java.util.List;

public interface AdminService {
    List<AdminDto> getAdmins();
    AdminDto getAdminById(Integer id);
    AdminDto createAdmin(AdminDto adminDto);
    AdminDto updateAdmin(Integer id, AdminDto adminDto);
    void deleteAdmin(Integer id);
}