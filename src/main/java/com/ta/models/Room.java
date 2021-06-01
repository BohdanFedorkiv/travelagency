package com.ta.models;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;


@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "rooms")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @Column(name = "number")
    private int number;

    @Column(name = "capacity")
    private int capacity;

    @NotNull
    @Column(name = "price")
    private double price;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;

    @Column(name = "available")
    private boolean available;

    @OneToMany(mappedBy = "rooms", cascade = CascadeType.ALL)
    private List<Order> orders;
}
