package com.example.teruzushi_project.modelo;

import jakarta.persistence.*;

@Entity
@Table(name = "tables")
public class Tables {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "capacity")
    private int Capacity;
    @ManyToOne
    @JoinColumn(name = "id_restaurant", nullable = false)
    private Restaurant restaurant;

    public Tables(int id, int capacity, Restaurant restaurant) {
        this.id = id;
        Capacity = capacity;
        this.restaurant = restaurant;
    }

    public Tables() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCapacity() {
        return Capacity;
    }

    public void setCapacity(int capacity) {
        Capacity = capacity;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }
}
