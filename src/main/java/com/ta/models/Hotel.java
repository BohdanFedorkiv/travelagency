package com.ta.models;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.Instant;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "hotels")
@Entity
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @Column(name = "name")
    private String name;

    @NotNull
    @Column(name = "country")
    private String country;

    @NotNull
    @Column(name = "city")
    private String city;

    @NotNull
    @Column(name = "capacity")
    private int capacity;

    @NotNull
    @Column(name = "stars")
    private int stars;

    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Room> rooms;
}
