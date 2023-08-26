package com.mekcoop.realestate.entity.business;

import com.mekcoop.realestate.entity.user.RealEstate;
import com.mekcoop.realestate.entity.user.User;
import com.mekcoop.realestate.entity.enums.EstateType;
import javax.persistence.*;
import lombok.*;

import java.util.Set;
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class Post {
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
    @OneToMany(mappedBy = "post")
    private Set<ImageFile> imageFiles;
    @OneToOne
    private User user;
    @ManyToOne
    private RealEstate realEstate;
}
