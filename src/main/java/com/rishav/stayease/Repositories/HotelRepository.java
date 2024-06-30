package com.rishav.stayease.Repositories;

import com.rishav.stayease.Entities.*;
import org.springframework.data.jpa.repository.JpaRepository;


public interface HotelRepository extends JpaRepository<Hotel,Long> {
    
}
