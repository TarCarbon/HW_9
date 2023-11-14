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
@Table (name = "property_rights")
public class PropertyRights {
    @Id
    @Column (name = "id")
    @Setter
    @Getter
    private int id;

    @Column (name = "property_right")
    @Getter
    @Setter
    private String propertyRight;

    @Getter
    @Setter
    @ManyToMany(mappedBy = "propertyRights", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Resident> resident = new HashSet<>();

}
