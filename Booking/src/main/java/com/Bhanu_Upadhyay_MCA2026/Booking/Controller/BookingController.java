package com.Bhanu_Upadhyay_MCA2026.Booking.Controller;

import com.Bhanu_Upadhyay_MCA2026.Booking.Model.Booking;
import com.Bhanu_Upadhyay_MCA2026.Booking.Services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @GetMapping("/bookings")
    public String getAllBookings(Model model) {
        model.addAttribute("bookings", bookingService.getAllBookings());
        return "bookings";
    }

    @GetMapping("/bookings/new")
    public String addBookingForm(Model model) {
        model.addAttribute("booking", new Booking());
        return "booking-form";
    }

    @PostMapping("/bookings")
    public String addBooking(@ModelAttribute("booking") Booking booking) {
        System.out.println("Booking data received: " + booking);
        bookingService.addBooking(booking);
        return "redirect:/bookings"; // Redirect back to the list after adding
    }


    @GetMapping("/bookings/edit/{id}")
    public String editBookingForm(@PathVariable String id, Model model) {
        model.addAttribute("booking", bookingService.getBookingById(id).orElse(null));
        return "booking-form";
    }

    @PostMapping("/bookings/update/{id}")
    public String updateBooking(@PathVariable String id, @ModelAttribute Booking booking) {
        bookingService.updateBooking(id, booking);
        return "redirect:/bookings";
    }

    @GetMapping("/bookings/delete/{id}")
    public String deleteBooking(@PathVariable String id) {
        bookingService.deleteBooking(id);
        return "redirect:/bookings";
    }
}



