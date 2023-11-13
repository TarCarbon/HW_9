package org.example.Entity;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@RequiredArgsConstructor
@Entity
@Table (name = "participants_OSBB")
public class ParticipantsOSBB {

    @Id
    @Getter
    @Setter
    private int id;

    @Column (name = "name")
    private String name;

    @OneToMany (mappedBy = "participant_OSBB_id", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Resident> residents = new ArrayList<>();
}
