package com.mekcoop.realestate.entity.user.concretes;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mekcoop.realestate.entity.business.Post;
import javax.persistence.*;

import com.mekcoop.realestate.entity.user.abstracts.BaseUser;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.Set;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@SuperBuilder
public class RealEstate extends BaseUser {
    private String companyName;
    private String authorizedName;
    private String authorizedSurname;
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
