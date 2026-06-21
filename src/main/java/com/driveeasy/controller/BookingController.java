package com.driveeasy.controller;

import com.driveeasy.model.Booking;
import com.driveeasy.service.BookingService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bookings")
@CrossOrigin(origins = "*")
public class BookingController {

    private final BookingService service;

    public BookingController(BookingService service) {
        this.service = service;
    }

    @PostMapping
    public Booking createBooking(
            @RequestBody Booking booking) {

        return service.save(booking);
    }

    @GetMapping
    public List<Booking> getBookings() {
        return service.getAllBookings();
    }

    @DeleteMapping("/{id}")
    public void deleteBooking(
            @PathVariable Long id) {

        service.deleteBooking(id);
    }
}