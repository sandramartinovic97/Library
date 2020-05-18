package com.library.library.service;

import com.library.library.dto.AdminDto;
import com.library.library.dto.AdminFactory;
import com.library.library.model.Admin;
import com.library.library.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class AdminServiceImplementation implements AdminService{
    @Autowired
    private AdminRepository adminRepository;
    @Autowired
    private AdminFactory adminFactory;

    @Override
    public List<Admin> getAdmins() {
        return adminRepository.findAll();
    }

    @Override
    public Admin getAdminById(Integer id) {
        return adminRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Could not find admin with id=" + id));
    }

    @Override
    public AdminDto createAdmin(AdminDto adminDto) {
        Admin admin = adminFactory.adminDtoToAdmin(adminDto);
        adminRepository.save(admin);

        return adminFactory.adminToAdminDto(admin);
    }

    @Override
    public AdminDto updateAdmin(Integer id, AdminDto adminDto) {
        Admin admin = getAdminById(id);
        Admin updatedAdmin = adminFactory.update(admin, adminDto);
        adminRepository.save(updatedAdmin);

        return adminFactory.adminToAdminDto(updatedAdmin);

/*        Admin admin = getAdminById(id);
        admin.setAdminUsername(adminDto.getAdminUsername());
        admin.setAdminEmail(adminDto.getAdminEmail());
        admin.setAdminPassword(adminDto.getAdminPassword());
        adminRepository.save(admin);
        return admin;*/
    }

    @Override
    public void deleteAdmin(Integer id) {
        adminRepository.deleteById(id);
    }
}