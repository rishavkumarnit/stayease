package com.rishav.stayease.Services;


import com.rishav.stayease.Exceptions.*;
import com.rishav.stayease.Entities.*;
import com.rishav.stayease.Repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;


@Service
public class HotelService {

    @Autowired
    private HotelRepository hotelRepository;



    public String addHotel(Hotelrequest request) {
        Hotel hotel = Hotel.builder()
        .name(request.getName())
        .location(request.getLocation())
        .description(request.getDescription())
        .availableRooms(request.getAvailableRooms())
        .build();

        hotelRepository.save(hotel);
        return "Hotel added";
    }



    
    public List<Hotel> getHotels() {
        return hotelRepository.findAll();
    }


    public Hotel getHotelById(Long id) {
        Optional<Hotel> hotel = hotelRepository.findById(id);
        if (!hotel.isPresent()) {
            throw new NotfoundException("Hotel not found");
        }
        return hotel.get();
    }



    public String deleteHotel(Long id) {
        if (!hotelRepository.existsById(id)) {
            throw new NotfoundException("Hotel  not found.");
        }
        hotelRepository.deleteById(id);
        return "Hotel deleted";
    }

}
