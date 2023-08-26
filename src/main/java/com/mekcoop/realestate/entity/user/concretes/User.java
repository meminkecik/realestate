package com.mekcoop.realestate.entity.user.concretes;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.*;
import com.mekcoop.realestate.entity.user.abstracts.BaseUser;
import lombok.*;
import lombok.experimental.SuperBuilder;


@Entity
@Table(name = "t_user")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class User extends BaseUser {

    @Column(unique = true)
    private String ssn;
    private String firstName;
    private String lastName;
    private String homePhone;
    @OneToOne
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private UserRole userRole;
}
