package com.Bhanu_Upadhyay_MCA2026.Booking.Services;

import com.Bhanu_Upadhyay_MCA2026.Booking.Repository.TravelPackageRepository;
import com.Bhanu_Upadhyay_MCA2026.Booking.Model.TravelPackage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TravelPackageService {

    @Autowired
    private TravelPackageRepository travelPackageRepository;

    public List<TravelPackage> getAllPackages() {
        return travelPackageRepository.findAll();
    }

    public Optional<TravelPackage> getPackageById(String id) {
        return travelPackageRepository.findById(id);
    }

    public TravelPackage addPackage(TravelPackage travelPackage) {
        return travelPackageRepository.save(travelPackage);
    }

    public TravelPackage updatePackage(String id, TravelPackage travelPackage) {
        if (travelPackageRepository.existsById(id)) {
            travelPackage.setId(id);
            return travelPackageRepository.save(travelPackage);
        }
        return null;
    }

    public void deletePackage(String id) {
        travelPackageRepository.deleteById(id);
    }
}


