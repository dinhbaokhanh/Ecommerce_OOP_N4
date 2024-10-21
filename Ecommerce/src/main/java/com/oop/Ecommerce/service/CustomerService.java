package com.oop.Ecommerce.service;

import com.oop.Ecommerce.dto.request.CustomerCreationRequest;
import com.oop.Ecommerce.dto.request.CustomerUpdateRequest;
import com.oop.Ecommerce.exception.AppException;
import com.oop.Ecommerce.exception.ErrorCode;
import com.oop.Ecommerce.model.Customer;
import com.oop.Ecommerce.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public Customer createCustomer(CustomerCreationRequest request){
        Customer customer = new Customer();

        if (customerRepository.existsByEmail(request.getEmail())){
            throw new AppException(ErrorCode.USER_EXISTED);
        }

        customer.setEmail(request.getEmail());
        customer.setName(request.getName());
        customer.setPassword(request.getPassword());
        customer.setRole(request.getRole());
        customer.setShippingAddress(request.getShippingAddress());

        return customerRepository.save(customer);
    }

    public List<Customer> getCustomer(){
        return customerRepository.findAll();
    }

    public Customer getCustomerById(String userId){
        return customerRepository.findById(userId).orElseThrow(() -> new RuntimeException("Customer not found"));
    }

    public Customer updateCustomer(String userId, CustomerUpdateRequest request){
        Customer customer = getCustomerById(userId);

        customer.setName(request.getName());
        customer.setPassword(request.getPassword());
        customer.setRole(request.getRole());
        customer.setShippingAddress(request.getShippingAddress());

        return customerRepository.save(customer);
    }

    public void deleteCustomer(String userId){
        customerRepository.deleteById(userId);
    }
}
