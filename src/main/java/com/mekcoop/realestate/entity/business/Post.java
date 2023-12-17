package com.mekcoop.realestate.entity.business;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mekcoop.realestate.entity.user.concretes.RealEstate;
import com.mekcoop.realestate.entity.user.concretes.User;
import com.mekcoop.realestate.entity.enums.EstateType;
import javax.persistence.*;
import lombok.*;

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
    private Double price;
    private String header;
    private String description;
    private Integer squareMeter;
    private Integer roomNumber;
    private Integer totalFloor;
    private Integer floor;
    private String typeOfHeating;
    private String city;
    private String address;
    @OneToOne
    private User user;
    @ManyToOne
    @JsonIgnore
    private RealEstate realEstate;
    private String imageUrl;

}
