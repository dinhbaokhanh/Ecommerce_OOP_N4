package com.oop.Ecommerce.model;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Admin extends User {
    @NotBlank(message = "Phone Number is mandatory")
    private String phoneNumber;

    public Admin() {
        super();
    }

    public Admin(String name, String email, String password, Role role) {
        super(name, email, password, role);
        this.phoneNumber = phoneNumber;
    }
}
