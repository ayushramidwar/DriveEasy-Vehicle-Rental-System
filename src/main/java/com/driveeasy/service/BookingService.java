package com.driveeasy.service;

import com.driveeasy.model.Booking;
import com.driveeasy.repository.BookingRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {

    private final BookingRepository repository;

    public BookingService(BookingRepository repository) {
        this.repository = repository;
    }

    public Booking save(Booking booking) {
        return repository.save(booking);
    }

    public List<Booking> getAllBookings() {
        return repository.findAll();
    }

    public void deleteBooking(Long id) {
        repository.deleteById(id);
    }
}