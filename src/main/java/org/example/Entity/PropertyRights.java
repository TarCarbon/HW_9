package org.example.Entity;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

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

}
