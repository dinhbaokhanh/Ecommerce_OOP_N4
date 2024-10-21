package com.oop.Ecommerce.repository;

import com.oop.Ecommerce.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
public interface CustomerRepository extends JpaRepository<Customer, String> {
}
