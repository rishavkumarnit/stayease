package com.rishav.stayease.Services;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rishav.stayease.Entities.Booking;
import com.rishav.stayease.Entities.Hotel;
import com.rishav.stayease.Repositories.BookingRepository;
import com.rishav.stayease.Repositories.HotelRepository;
import com.rishav.stayease.Repositories.UserRepository;

import jakarta.validation.ValidationException;


@Service
public class BookingService {


    @Autowired
    private HotelService hotelService;


    @Autowired
    private BookingRepository bookingRepository;


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private HotelRepository hotelRepository;


    public String bookRoom(String email, Long hotelId) {
        Hotel hotel = hotelService.getHotelById(hotelId);

        if (hotel.getAvailableRooms() == 0) {
            throw new ValidationException("No rooms available in this hotel");
        }
        hotel.setAvailableRooms(hotel.getAvailableRooms() - 1);
        Booking booking = new Booking();
        booking.setUsermail(email);
        booking.setIdhotel(hotelId);
        hotelRepository.save(hotel);
        bookingRepository.save(booking);

        return "Room booked successfully : your Booking id is : " + booking.getId();
    }

    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    public Optional<Booking> getBookingById(Long id) {
        return bookingRepository.findById(id);
    }


    public String deleteBooking(Long id) {
        if (!bookingRepository.existsById(id)) {
            throw new ValidationException("Booking not found");
        }
        
        Optional<Booking> booking = bookingRepository.findById(id);
        Optional<Hotel> hotel = hotelRepository.findById(booking.get().getIdhotel());
        hotel.get().setAvailableRooms(hotel.get().getAvailableRooms() + 1);
        bookingRepository.deleteById(id);
        hotelRepository.save(hotel.get());
        return "Booking deleted successfully";
    }
}
