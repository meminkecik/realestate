package com.mekcoop.realestate.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder(toBuilder = true)
public class RealEstate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String companyName;
    private String authorizedName;
    private String authorizedSurname;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
    @Column(unique = true)
    private String phone;
    @Column(unique = true)
    private String faxNumber;
    private String address;
    @Column(unique = true)
    private String taxNumber;
    @OneToMany(mappedBy = "realEstate",cascade = CascadeType.ALL)
    private Set<Estate> estateList;

    
}
