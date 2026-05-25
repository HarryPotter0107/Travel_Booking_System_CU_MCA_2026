package com.Bhanu_Upadhyay_MCA2026.Booking.Controller;

import com.Bhanu_Upadhyay_MCA2026.Booking.Model.TravelPackage;
import com.Bhanu_Upadhyay_MCA2026.Booking.Services.TravelPackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/packages")
public class TravelPackageController {

    @Autowired
    private TravelPackageService travelPackageService;

    @GetMapping
    public String getAllPackages(Model model) {
        model.addAttribute("packages", travelPackageService.getAllPackages());
        return "packages";
    }

    @GetMapping("/{id}")
    public String getPackageById(@PathVariable String id, Model model) {
        model.addAttribute("travelPackage", travelPackageService.getPackageById(id).orElse(null));
        return "package-detail";
    }

    @GetMapping("/new")
    public String addPackageForm(Model model) {
        model.addAttribute("travelPackage", new TravelPackage());
        return "package-form";
    }

    @PostMapping("/add")
    public String addPackage(@ModelAttribute TravelPackage travelPackage) {
        travelPackageService.addPackage(travelPackage);
        return "redirect:/packages";
    }

    @GetMapping("/edit/{id}")
    public String editPackageForm(@PathVariable String id, Model model) {
        model.addAttribute("travelPackage", travelPackageService.getPackageById(id).orElse(null));
        return "package-form";
    }

    @PostMapping("/update/{id}")
    public String updatePackage(@PathVariable String id, @ModelAttribute TravelPackage travelPackage) {
        travelPackageService.updatePackage(id, travelPackage);
        return "redirect:/packages";
    }

    @GetMapping("/delete/{id}")
    public String deletePackage(@PathVariable String id) {
        travelPackageService.deletePackage(id);
        return "redirect:/packages";
    }
}


