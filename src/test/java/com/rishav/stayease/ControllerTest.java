package com.rishav.stayease;

import com.rishav.stayease.Controllers.*;
import com.rishav.stayease.Entities.*;
import com.rishav.stayease.Services.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import java.util.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;



public class ControllerTest {


    @Mock
    private HotelService hotelService;


    @InjectMocks
    private HotelController hotelController;


    private MockMvc mockMvc;


    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(hotelController).build();
    }


    @Test
    public void testGetHotels_returnsStatusOk() throws Exception {
        List<Hotel> hotels = new ArrayList<>();
        Hotel hotel1 = new Hotel();
        hotel1.setId(1L);
        hotel1.setName("Hotel A");
        hotels.add(hotel1);

        when(hotelService.getHotels()).thenReturn(hotels);

        mockMvc.perform(get("/hotels"))
                .andExpect(status().isOk());

        verify(hotelService, times(1)).getHotels();
    }


    @Test
    public void testGetHotels_returnsJsonContent() throws Exception {
        List<Hotel> hotels = new ArrayList<>();
        Hotel hotel1 = new Hotel();
        hotel1.setId(1L);
        hotel1.setName("Hotel A");
        hotels.add(hotel1);

        when(hotelService.getHotels()).thenReturn(hotels);

        mockMvc.perform(get("/hotels"))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));

        verify(hotelService, times(1)).getHotels();
    }


    @Test
    public void testGetHotels_returnsCorrectData() throws Exception {
        List<Hotel> hotels = new ArrayList<>();
        Hotel hotel1 = new Hotel();
        hotel1.setId(1L);
        hotel1.setName("Hotel A");
        hotels.add(hotel1);

        when(hotelService.getHotels()).thenReturn(hotels);

        mockMvc.perform(get("/hotels"))
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].name").value("Hotel A"));

        verify(hotelService, times(1)).getHotels();
    }

    
    @Test
    public void testGetHotelById() throws Exception {
        Hotel hotel = new Hotel();
        hotel.setId(1L);
        hotel.setName("Hotel A");

        when(hotelService.getHotelById(1L)).thenReturn(hotel);

        mockMvc.perform(get("/hotels/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.name").value("Hotel A"));

        verify(hotelService, times(1)).getHotelById(1L);
    }




}