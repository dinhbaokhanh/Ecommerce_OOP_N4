package com.oop.Ecommerce.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
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

    public Admin(String userId, String name, String email, String password, Role role) {
        super(userId, name, email, password, role);
        this.phoneNumber = phoneNumber;
    }

    public @NotBlank(message = "Phone Number is mandatory") String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(@NotBlank(message = "Phone Number is mandatory") String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
