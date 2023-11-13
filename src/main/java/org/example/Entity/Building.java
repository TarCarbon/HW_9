package org.example.Entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table (name = "buildings")
public class Building {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private int id;

    @Column(name = "address")
    @Getter
    @Setter
    private String address;

    @ManyToMany
    @JoinTable (name = "builders_to_apartments",
            joinColumns = @JoinColumn(name = "building_id"),
            inverseJoinColumns = @JoinColumn(name = "apartment_id"))
    @Getter
    @Setter
    private Set<Apartment> apartments = new HashSet<>();

}
