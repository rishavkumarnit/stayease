package com.rishav.stayease.Controllers;



import com.rishav.stayease.Entities.Hotel;
import com.rishav.stayease.Entities.Hotelrequest;
import com.rishav.stayease.Services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import java.util.*;



@Slf4j
@RestController
@RequestMapping("/hotels")
public class HotelController {

    @Autowired
    HotelService hotelService;


    @PostMapping
    public ResponseEntity<String> addHotel(@RequestBody Hotelrequest hotel) {
        log.info("Adding hotel: {}", hotel);
        String response = hotelService.addHotel(hotel);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }



    @GetMapping
    public ResponseEntity<List<Hotel>> getHotels() {
        log.info("Fetching hotel list");
        List<Hotel> hotels = hotelService.getHotels();
        return ResponseEntity.ok(hotels);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Hotel> getHotelById(@PathVariable Long id) {
        log.info("Fetching hotel : {}", id);
        Hotel hotel = hotelService.getHotelById(id);
        return ResponseEntity.ok(hotel);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteHotel(@PathVariable Long id) {
        log.info("Deleting hotel : {}", id);
        String response = hotelService.deleteHotel(id);
        return ResponseEntity.ok(response);
    }
}