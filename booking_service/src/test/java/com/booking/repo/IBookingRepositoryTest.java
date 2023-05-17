package com.booking.repo;

import com.booking.entity.Bookings;
import com.booking.repository.IBookingRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class IBookingRepositoryTest {

    @Autowired
    private IBookingRepository iBookingRepository;
    @Test
    void getBookingById() {
        List<Integer> passengerList = new ArrayList<Integer>();
        passengerList.add(1);
        Bookings ticket = new Bookings(123,1,"AC", 1, 1,passengerList);
        iBookingRepository.save(ticket);

        List<Bookings> allBookings =  iBookingRepository.getBookingById(1);


    }
}