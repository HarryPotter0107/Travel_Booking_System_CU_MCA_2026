package com.Bhanu_Upadhyay_MCA2026.Booking.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "travel_packages")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TravelPackage {
    @Id
    private String id;
    private String destination;
    private int duration;
    private double price;
    private String description;
}


