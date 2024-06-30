package com.rishav.stayease.Controllers;



import com.rishav.stayease.Entities.*;
import com.rishav.stayease.Services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import java.util.*;
import lombok.extern.slf4j.Slf4j;




@RestController
@Slf4j
@RequestMapping("/bookings")
public class BookingController {

    private final BookingService bookingService;

    @Autowired
    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping("/{idhotel}")
    public ResponseEntity<String> bookRoom(@PathVariable Long idhotel) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = ((UserDetails) authentication.getPrincipal()).getUsername();
        String response = bookingService.bookRoom(email, idhotel);
        log.info("Booking room in hotel: {} by Customer : {}", idhotel, email);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<List<Booking>> getAllBookings() {
        log.info("Fetching all booking details");
        List<Booking> bookings = bookingService.getAllBookings();
        return ResponseEntity.ok(bookings);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Booking> getBookingById(@PathVariable Long id) {
        log.info("Fetching booking details by id : {}", id);
        Optional<Booking> booking = bookingService.getBookingById(id);
        return booking.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBooking(@PathVariable Long id) {
        log.info("Deleting booking details by id : {}", id);
        String response = bookingService.deleteBooking(id);
        return ResponseEntity.ok(response);
    }
}
