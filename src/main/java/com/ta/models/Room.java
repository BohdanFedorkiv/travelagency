package com.ta.models;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;


//@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "rooms")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @Column(name = "number")
    private int number;

    @NotNull
    @Column(name = "capacity")
    private int capacity;

    @NotNull
    @Column(name = "price")
    private double price;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "room", cascade = CascadeType.ALL)
    private List<Order> orders;

    public long getId() {
        return id;
    }

    public int getNumber() {
        return number;
    }

    public int getCapacity() {
        return capacity;
    }

    public double getPrice() {
        return price;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
