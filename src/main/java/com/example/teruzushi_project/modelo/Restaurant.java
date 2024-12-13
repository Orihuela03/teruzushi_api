package com.example.teruzushi_project.modelo;

import jakarta.persistence.*;

@Entity
@Table (name = "restaurant")
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    @Column(name = "name")
    private String Name;
    @Column(name = "address")
    private String Address;
    @Column(name = "capacity")
    private int Capacity;

    public Restaurant(int id, String name, String address, int capacity) {
        Id = id;
        Name = name;
        Address = address;
        Capacity = capacity;
    }

    public Restaurant() {}

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public int getCapacity() {
        return Capacity;
    }

    public void setCapacity(int capacity) {
        Capacity = capacity;
    }
}
