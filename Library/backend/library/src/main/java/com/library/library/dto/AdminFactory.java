package com.library.library.dto;

import com.library.library.model.Admin;
import org.springframework.stereotype.Component;

@Component
public class AdminFactory {

    public AdminDto adminToAdminDto(Admin admin) {
        AdminDto adminDto = new AdminDto.Builder(admin.getId())
                .adminUsername(admin.getAdminUsername())
                .adminEmail(admin.getAdminEmail())
                .adminPassword(admin.getAdminPassword())
                .build();
        return adminDto;
    }

    public Admin adminDtoToAdmin(AdminDto adminDto) {
        Admin admin = new Admin();
        admin.setId(adminDto.getId());
        admin.setAdminUsername(adminDto.getAdminUsername());
        admin.setAdminEmail(adminDto.getAdminEmail());
        admin.setAdminPassword(adminDto.getAdminPassword());

        return admin;

/*        Admin admin = new Admin.Builder(adminDto.getId())
                .adminUsername(adminDto.getAdminUsername())
                .adminEmail(adminDto.getAdminEmail())
                .adminPassword(adminDto.getAdminPassword())
                .build();
        return admin;*/
    }

    public Admin update(Admin admin, AdminDto adminDto) {
        admin.setAdminUsername(adminDto.getAdminUsername());
        admin.setAdminEmail(adminDto.getAdminEmail());
        admin.setAdminPassword(adminDto.getAdminPassword());

        return admin;
    }
}