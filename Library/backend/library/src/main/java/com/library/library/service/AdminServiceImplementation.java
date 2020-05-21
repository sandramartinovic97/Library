package com.library.library.service;

import com.library.library.dto.AdminDto;
import com.library.library.model.Admin;
import com.library.library.repository.AdminRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service
public class AdminServiceImplementation implements AdminService{
    @Autowired
    private AdminRepository adminRepository;
    private ModelMapper modelMapper = new ModelMapper();

    @Override
    public List<AdminDto> getAdmins() {
        List<Admin> admins = adminRepository.findAll();
        List<AdminDto> adminDtos = new ArrayList<>();
        for (Admin admin : admins) {
            AdminDto adminDto = modelMapper.map(admin, AdminDto.class);
            adminDtos.add(adminDto);
        }
        return adminDtos;
    }

    @Override
    public AdminDto getAdminById(Integer id) {
        Admin admin = adminRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Could not find admin with id=" + id));

        return modelMapper.map(admin, AdminDto.class);
    }

    @Override
    public AdminDto createAdmin(AdminDto adminDto) {
        Admin admin = modelMapper.map(adminDto, Admin.class);
        adminRepository.save(admin);

        return modelMapper.map(admin, AdminDto.class);
    }

    @Override
    public AdminDto updateAdmin(Integer id, AdminDto adminDto) {
        Admin updatedAdmin = modelMapper.map(adminDto, Admin.class);
        Admin admin = adminRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Could not find admin with id=" + id));
        admin.setAdminUsername(updatedAdmin.getAdminUsername());
        admin.setAdminEmail(updatedAdmin.getAdminEmail());
        admin.setAdminPassword(updatedAdmin.getAdminPassword());
        adminRepository.save(admin);

        return modelMapper.map(admin, AdminDto.class);
    }

    @Override
    public void deleteAdmin(Integer id) {
        adminRepository.deleteById(id);
    }
}