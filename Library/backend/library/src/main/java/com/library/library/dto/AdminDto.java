package com.library.library.dto;

import lombok.Data;

@Data
public class AdminDto {

    private Integer id;
    private String adminUsername;
    private String adminEmail;
    private String adminPassword;

    public static class Builder {

        private Integer id;
        private String adminUsername;
        private String adminEmail;
        private String adminPassword;

        public Builder(Integer id) {
            this.id = id;
        }

        public Builder adminUsername(String adminUsername) {
            this.adminUsername = adminUsername;
            return this;
        }

        public Builder adminEmail(String adminEmail) {
            this.adminEmail = adminEmail;
            return this;
        }

        public Builder adminPassword(String adminPassword) {
            this.adminPassword = adminPassword;
            return this;
        }

        public AdminDto build() {
            AdminDto adminDto = new AdminDto();
            adminDto.id = this.id;
            adminDto.adminUsername = this.adminUsername;
            adminDto.adminEmail = this.adminEmail;
            adminDto.adminPassword = this.adminPassword;

            return adminDto;
        }
    }
}