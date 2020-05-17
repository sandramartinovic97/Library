package com.library.library.service;

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

    @Override
    public List<Admin> getAdmins() {
        return adminRepository.findAll();
    }

    @Override
    public Admin getAdminById(Integer id) {
        return adminRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Could not find admin with id=" + id));
    }

    @Override
    public Admin createAdmin(Admin admin) {
        return adminRepository.save(admin);
    }

    @Override
    public Admin updateAdmin(Integer id, Admin admin) {
        Admin adminDB = getAdminById(id);
        adminDB.setAdminUsername(admin.getAdminUsername());
        adminDB.setAdminEmail(admin.getAdminEmail());
        adminDB.setAdminPassword(admin.getAdminPassword());
        return adminRepository.save(adminDB);
    }

    @Override
    public void deleteAdmin(Integer id) {
        adminRepository.deleteById(id);
    }
}
