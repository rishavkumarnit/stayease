package com.rishav.stayease.Entities;



import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;



@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String name;


    private String location;

    
    private String description;


    private int availableRooms;
}