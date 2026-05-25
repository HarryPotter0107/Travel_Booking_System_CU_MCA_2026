package com.Bhanu_Upadhyay_MCA2026.Booking.Controller;

import com.Bhanu_Upadhyay_MCA2026.Booking.Model.Customer;
import com.Bhanu_Upadhyay_MCA2026.Booking.Services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping
    public String getAllCustomers(Model model) {
        model.addAttribute("customers", customerService.getAllCustomers());
        return "customers";
    }

    @GetMapping("/{id}")
    public String getCustomerById(@PathVariable String id, Model model) {
        model.addAttribute("customer", customerService.getCustomerById(id).orElse(null));
        return "customer-detail";
    }

    @GetMapping("/new")
    public String addCustomerForm(Model model) {
        model.addAttribute("customer", new Customer());
        return "customer-form";
    }

    @PostMapping("/add")
    public String addCustomer(@ModelAttribute Customer customer, BindingResult result) {
        if (result.hasErrors()) {
            return "customer-form";
        }
        customerService.addCustomer(customer);
        return "redirect:/customers";
    }

    @GetMapping("/edit/{id}")
    public String editCustomerForm(@PathVariable String id, Model model) {
        model.addAttribute("customer", customerService.getCustomerById(id).orElse(null));
        return "customer-form";
    }

    @PostMapping("/update/{id}")
    public String updateCustomer(@PathVariable String id, @ModelAttribute Customer customer, BindingResult result) {
        if (result.hasErrors()) {
            return "customer-form";
        }
        customerService.updateCustomer(id, customer);
        return "redirect:/customers";
    }

    @GetMapping("/delete/{id}")
    public String deleteCustomer(@PathVariable String id) {
        customerService.deleteCustomer(id);
        return "redirect:/customers";
    }
}



