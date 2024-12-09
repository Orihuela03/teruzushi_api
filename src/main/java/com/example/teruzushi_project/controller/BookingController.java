package com.example.teruzushi_project.controller;

import com.example.teruzushi_project.modelo.Booking;
import com.example.teruzushi_project.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/teruzushiapi/booking")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @GetMapping
    public List<Booking> getBookings() {
        return bookingService.getAllBookings();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Booking> getBookingById(@PathVariable int id) {
        Optional<Booking> booking = bookingService.getBookingById(id);
        return booking.map(ResponseEntity::ok)
                .orElseGet(() ->ResponseEntity.notFound().build());
    }

    @PostMapping("/booking")
    public ResponseEntity<Booking> addBooking(@RequestBody Booking booking) {
        try {
            Booking newBooking = bookingService.addBooking(booking);
            return ResponseEntity.ok(newBooking);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null);
        }
    }

    @PutMapping("/{id}")
    public Booking updateBooking(@PathVariable int id, @RequestBody Booking updatedBooking) {
        updatedBooking.setId(id);
        return bookingService.updateBooking(updatedBooking);
    }

    @DeleteMapping("/{id}")
    public void deleteBooking(@PathVariable int id) {
        bookingService.deleteBooking(id);
    }
}
