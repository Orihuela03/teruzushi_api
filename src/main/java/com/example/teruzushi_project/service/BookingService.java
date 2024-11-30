package com.example.teruzushi_project.service;

import com.example.teruzushi_project.modelo.Booking;
import com.example.teruzushi_project.repository.BookingRepository;
import com.example.teruzushi_project.repository.TablesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    public Optional<Booking> getBookingById(Integer id) {
        return bookingRepository.findById(id);
    }

    public Booking saveBooking(Booking booking) {
        return bookingRepository.save(booking);
    }

    public void deleteBooking(Integer id) {
        bookingRepository.deleteById(id);
    }

    public Booking updateBooking(Booking booking) {
        if (bookingRepository.findById(booking.getId()).isPresent()) {
            Booking updatedBooking = bookingRepository.getById(booking.getId());
            updatedBooking.setCustomerName(booking.getCustomerName());
            updatedBooking.setCustomerEmail(booking.getCustomerEmail());
            updatedBooking.setCustomerPhone(booking.getCustomerPhone());
            updatedBooking.setNumberOfEaters(booking.getNumberOfEaters());
            updatedBooking.setDate(booking.getDate());
            updatedBooking.setTables(booking.getTables());
            return bookingRepository.save(updatedBooking);
        }
        else {
            return null;
        }
    }

}
