package com.Bhanu_Upadhyay_MCA2026.Booking.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Document(collection = "bookings")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Booking {
    @Id
    private String id;
    private String customerId;
    private String packageId;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date bookingDate;

    private String status;
}




