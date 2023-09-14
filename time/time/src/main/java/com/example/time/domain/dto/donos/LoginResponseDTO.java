package com.example.time.domain.dto.donos;

public class LoginResponseDTO {
    private String token;
    private DonoResponseDTO dono;
    
    public String getToken() {
        return token;
    }
    public void setToken(String token) {
        this.token = token;
    }
    public DonoResponseDTO getDono() {
        return dono;
    }
    public void setDono(DonoResponseDTO dono) {
        this.dono = dono;
    }
}
