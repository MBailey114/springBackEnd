package com.simplishop.security;

import lombok.Data;

@Data
public class RegisterResponseDTO {
    private String statusMessage;
    public RegisterResponseDTO(String statusMessage) {
        this.statusMessage= statusMessage;
    }
}
