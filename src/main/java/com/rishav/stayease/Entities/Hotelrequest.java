package com.rishav.stayease.Entities;



import lombok.*;




@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Hotelrequest {

    private String name;
    private String location;
    private String description;
    private int availableRooms;
}
