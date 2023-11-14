package org.example.entity;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
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

    @ManyToMany (mappedBy = "apartments", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @Getter
    @Setter
    private Set<Building> buildings= new HashSet<>();

    @ManyToMany (mappedBy = "apartments", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @Getter
    @Setter
    private Set<Resident> residents = new HashSet<>();

    @Getter
    @Setter
    @ManyToMany (cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "participant_to_apartments",
    joinColumns = @JoinColumn(name = "apartment_id"),
    inverseJoinColumns = @JoinColumn(name = "participant_OSBB_id"))
    private Set<ParticipantsOSBB> participantsOSBB = new HashSet<>();
}
