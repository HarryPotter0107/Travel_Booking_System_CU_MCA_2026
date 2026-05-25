package com.Bhanu_Upadhyay_MCA2026.Booking.Repository;

import com.Bhanu_Upadhyay_MCA2026.Booking.Model.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends MongoRepository<Customer,String> {
}


