package com.rishav.stayease.Entities;


import lombok.*;




@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginRequest {
    private String email;
    private String password;
}