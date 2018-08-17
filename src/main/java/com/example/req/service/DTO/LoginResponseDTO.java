package com.example.req.service.DTO;

public class LoginResponseDTO {
    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public LoginResponseDTO() {
    }

    public LoginResponseDTO(final String token) {
        this.token = token;
    }
}
