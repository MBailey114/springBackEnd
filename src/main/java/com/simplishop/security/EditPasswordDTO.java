package com.simplishop.security;

import lombok.Data;

@Data
public class EditPasswordDTO {
    private String currentPassword;
    private String newPassword;
}
