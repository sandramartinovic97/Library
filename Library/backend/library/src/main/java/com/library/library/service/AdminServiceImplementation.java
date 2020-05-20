package com.library.library.service;

import com.library.library.dto.AdminDto;
import com.library.library.model.Admin;
import com.library.library.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service
public class AdminServiceImplementation implements AdminService{
    @Autowired
    private AdminRepository adminRepository;

    @Override
    public List<AdminDto> getAdmins() {
        List<Admin> admins = adminRepository.findAll();
        List<AdminDto> adminDtos = new ArrayList<>();
        for (Admin admin : admins) {
            adminDtos.add(entityToDto(admin));
        }
        return adminDtos;
    }

    @Override
    public AdminDto getAdminById(Integer id) {
        Admin admin = adminRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Could not find admin with id=" + id));
        AdminDto adminDto = entityToDto(admin);

        return adminDto;
    }

    @Override
    public AdminDto createAdmin(AdminDto adminDto) {
        Admin admin = dtoToEntity(adminDto);
        Admin newAdmin = adminRepository.save(admin);
        AdminDto newAdminDto = entityToDto(newAdmin);

        return newAdminDto;
    }

    @Override
    public AdminDto updateAdmin(Integer id, AdminDto adminDto) {
        Admin updatedAdmin = dtoToEntity(adminDto);
        Admin admin = adminRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Could not find admin with id=" + id));
        admin.setAdminUsername(updatedAdmin.getAdminUsername());
        admin.setAdminEmail(updatedAdmin.getAdminEmail());
        admin.setAdminPassword(updatedAdmin.getAdminPassword());
        Admin adminSaved = adminRepository.save(admin);
        AdminDto newAdminDto = entityToDto(adminSaved);

        return newAdminDto;
    }

    @Override
    public void deleteAdmin(Integer id) {
        adminRepository.deleteById(id);
    }

    private AdminDto entityToDto(Admin admin) {
        AdminDto adminDto = new AdminDto();
        adminDto.setId(admin.getId());
        adminDto.setAdminUsername(admin.getAdminUsername());
        adminDto.setAdminEmail(admin.getAdminEmail());
        adminDto.setAdminPassword(admin.getAdminPassword());

        return adminDto;
    }

    private Admin dtoToEntity(AdminDto adminDto) {
        Admin admin = new Admin();
        admin.setId(adminDto.getId());
        admin.setAdminUsername(adminDto.getAdminUsername());
        admin.setAdminEmail(adminDto.getAdminEmail());
        admin.setAdminPassword(adminDto.getAdminPassword());

        return admin;
    }
}