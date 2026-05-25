package com.Bhanu_Upadhyay_MCA2026.Booking.Repository;

import com.Bhanu_Upadhyay_MCA2026.Booking.Model.Booking;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends MongoRepository<Booking,String> {
}



