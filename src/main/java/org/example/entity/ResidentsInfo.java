package org.example.entity;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
@Data
@RequiredArgsConstructor
public class ResidentsInfo {
    @Getter
    @Setter
    private String name;
    @Getter
    @Setter
    private String sname;
    @Getter
    @Setter
    private String email;
    @Getter
    @Setter
    private String address;
    @Getter
    @Setter
    private String apartmentNumber;
    @Getter
    @Setter
    private String apartmentsArea;
}
