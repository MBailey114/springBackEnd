package com.simplishop.security;

import lombok.Data;

@Data
public class EditPasswordResponseDTO {
    private String statusMessage;
    public EditPasswordResponseDTO(String statusMessage) {
        this.statusMessage = statusMessage;
    }
}
