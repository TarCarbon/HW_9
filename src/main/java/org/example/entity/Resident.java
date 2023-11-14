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
@Table (name = "residents")
public class Resident {

    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Getter
    @Setter
    @Column (name = "name")
    private String name;

    @Column (name = "sname")
    @Getter
    @Setter
    private String surname;

    @Column (name = "email")
    @Getter
    @Setter
    private String email;

    @Column (name = "drive_into_the_territory")
    @Getter
    @Setter
    private boolean driveIntoTheTerritory;

    @Getter
    @Setter
    @Column (name = "participant_OSBB_id")
    @ManyToOne (fetch = FetchType.LAZY)
    private ParticipantsOSBB participantOSBBid;

    @Getter
    @Setter
    @ManyToMany (cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "residents_to_apartments",
    joinColumns = @JoinColumn(name = "residents_id"),
    inverseJoinColumns = @JoinColumn(name = "apartment_id"))
    private Set<Apartment> apartments = new HashSet<>();

    @Getter
    @Setter
    @ManyToMany (cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable (name = "property_rights_to_residents",
    joinColumns = @JoinColumn (name = "resident_id"),
    inverseJoinColumns = @JoinColumn(name = "property_right_id"))
    private Set<PropertyRights> propertyRights = new HashSet<>();

}
