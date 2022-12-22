package com.simplishop.security;

import lombok.Data;

@Data
public class EmailResponseDTO {
    private String emailAddress;
    private Boolean emailTaken;
    public EmailResponseDTO(String emailAddress, Boolean emailTaken) {
        this.emailTaken = emailTaken;
        this.emailAddress = emailAddress;
    }
}
