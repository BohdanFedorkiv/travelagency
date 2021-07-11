package com.ta.models;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Column(name = "checkin")
    private LocalDate checkin;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Column(name = "checkout")
    private LocalDate checkout;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;

    public long getId() {
        return id;
    }

    public LocalDate getCheckin() {
        return checkin;
    }

    public void setCheckin(LocalDate checkin) {
        this.checkin = checkin;
    }
    public LocalDate getCheckout() { return checkout; }

    public void setCheckout(LocalDate checkout) {
        this.checkout = checkout;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }


}
