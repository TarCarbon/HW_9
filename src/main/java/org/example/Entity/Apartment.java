package org.example.Entity;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@RequiredArgsConstructor
@Entity
@Table (name = "apartments")
public class Apartment {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private int id;
    @Column (name = "number ")
    private int number;
    @Column (name = "area")
    private int area;

    @ManyToMany (mappedBy = "apartments")
    @Getter
    @Setter
    private Set<Building> buildingId = new HashSet<>();

    @ManyToMany (mappedBy = "apartments")
    @Getter
    @Setter
    private Set<Resident> residents = new HashSet<>();
}
