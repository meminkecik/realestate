package com.mekcoop.realestate.entity;

import com.mekcoop.realestate.entity.enums.EstateType;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Set;
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class Estate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private EstateType estateType;
    private Integer squareMeter;
    private Integer roomNumber;
    private Integer totalFloor;
    private Integer floor;
    private String typeOfHeating;
    private String city;
    private String address;
    @OneToMany(mappedBy = "estate")
    private Set<ImageFile> imageFiles;
    @OneToOne
    private User user;
    @ManyToOne
    private RealEstate realEstate;
}
