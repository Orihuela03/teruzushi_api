package com.example.teruzushi_project.modelo;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table (name = "booking")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    private String CustomerName;
    private String CustomerEmail;
    private String CustomerPhone;
    private int NumberOfEaters;
    private Date Date;
    @ManyToOne
    @JoinColumn(name = "id_restaurant", nullable = false)
    private Restaurant restaurant;

    public Booking(int id, String customerName, String customerEmail, String customerPhone, int numberOfEaters, java.util.Date date, Restaurant restaurant) {
        Id = id;
        CustomerName = customerName;
        CustomerEmail = customerEmail;
        CustomerPhone = customerPhone;
        NumberOfEaters = numberOfEaters;
        Date = date;
        this.restaurant = restaurant;
    }

    public Booking( ) {
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getCustomerName() {
        return CustomerName;
    }

    public void setCustomerName(String customerName) {
        CustomerName = customerName;
    }

    public String getCustomerEmail() {
        return CustomerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        CustomerEmail = customerEmail;
    }

    public String getCustomerPhone() {
        return CustomerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        CustomerPhone = customerPhone;
    }

    public int getNumberOfEaters() {
        return NumberOfEaters;
    }

    public void setNumberOfEaters(int numberOfEaters) {
        NumberOfEaters = numberOfEaters;
    }

    public java.util.Date getDate() {
        return Date;
    }

    public void setDate(java.util.Date date) {
        Date = date;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restuarant) {
        this.restaurant = restaurant;
    }
}
