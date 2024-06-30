package com.rishav.stayease.Repositories;


import com.rishav.stayease.Entities.*;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.*;



public interface BookingRepository extends JpaRepository<Booking,Long> {
    
}