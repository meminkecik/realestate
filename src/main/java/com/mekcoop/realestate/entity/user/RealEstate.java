package com.mekcoop.realestate.entity.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mekcoop.realestate.entity.business.Post;
import javax.persistence.*;
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
    @Column(unique = true)
    private String email;
    private String authorizedName;
    private String authorizedSurname;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
    @Column(unique = true)
    private String phoneNumber;
    @Column(unique = true)
    private String faxNumber;
    private String address;
    @Column(unique = true)
    private String taxNumber;
    @OneToMany(mappedBy = "realEstate",cascade = CascadeType.ALL)
    private Set<Post> estateList;
    @OneToOne
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private UserRole userRole;
    
}
