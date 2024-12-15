package com.example.teruzushi_project.controller;

import com.example.teruzushi_project.modelo.Booking;
import com.example.teruzushi_project.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @GetMapping
    public List<Booking> getAllBookings() {
        return bookingService.getAllBookings();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Booking> getBookingById(@PathVariable Long id) {
        return bookingService.getBookingById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Booking> createBooking(@RequestBody Booking booking) {
        // Validamos que la reserva tenga un restaurante asociado
        if (booking.getRestaurant() == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(bookingService.saveBooking(booking));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Booking> updateBooking(@PathVariable Long id, @RequestBody Booking booking) {
        return bookingService.getBookingById(id).map(existing -> {
            existing.setCustomerName(booking.getCustomerName());
            existing.setCustomerEmail(booking.getCustomerEmail());
            existing.setCustomerPhone(booking.getCustomerPhone());
            existing.setNumberOfEaters(booking.getNumberOfEaters());
            existing.setDate(booking.getDate());
            existing.setRestaurant(booking.getRestaurant());
            bookingService.saveBooking(existing);
            return ResponseEntity.ok(existing);
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBooking(@PathVariable Long id) {
        if (bookingService.getBookingById(id).isPresent()) {
            bookingService.deleteBooking(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}