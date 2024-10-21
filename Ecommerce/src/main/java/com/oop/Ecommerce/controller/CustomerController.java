package com.oop.Ecommerce.controller;

import com.oop.Ecommerce.dto.request.CustomerCreationRequest;
import com.oop.Ecommerce.dto.request.CustomerUpdateRequest;
import com.oop.Ecommerce.model.Customer;
import com.oop.Ecommerce.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @PostMapping()
    Customer createCustomer(@RequestBody CustomerCreationRequest request){
        return customerService.createCustomer(request);
    }

    @GetMapping()
    List<Customer> getCustomers(){
        return customerService.getCustomer();
    }

    @GetMapping("/{userId}")
    Customer getCustomer(@PathVariable("userId") String userId){
        return customerService.getCustomerById(userId);
    }

    @PutMapping("/{userId}")
    Customer updateCustomer(@PathVariable("userId") String userId,
                            @RequestBody CustomerUpdateRequest request){
        return customerService.updateCustomer(userId, request);
    }

    @DeleteMapping("/{userId}")
    String deleteCustomer(@PathVariable("userId") String userId){
        customerService.deleteCustomer(userId);
        return "User has been deleted";
    }
}
