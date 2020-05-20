package com.library.library.dto;

import lombok.Data;

@Data
public class AdminDto {
    private Integer id;
    private String adminUsername;
    private String adminEmail;
    private String adminPassword;
}