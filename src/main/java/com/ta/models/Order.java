package com.ta.models;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;


@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @Column(name = "number")
    private int number;

//    @NotNull
//    @ManyToOne
//    @JoinColumn(name = "room_id")
//    private Room room;

//    @NotNull
//    @ManyToOne
//    @JoinColumn(name = "person_id")
//    private Person person;

    @NotNull
    @Column(name = "checkin")
    private LocalDate checkin;

    @NotNull
    @Column(name = "checkout")
    private LocalDate checkout;
}
