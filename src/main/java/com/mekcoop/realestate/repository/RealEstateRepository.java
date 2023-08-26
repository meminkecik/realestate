package com.mekcoop.realestate.repository;

import com.mekcoop.realestate.entity.user.RealEstate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RealEstateRepository extends JpaRepository<RealEstate,Long> {
    boolean existsByTaxNumber(String taxNumber);

    boolean existsByEmail(String email);

    boolean existsByPhoneNumber(String phoneNumber);

    Optional<RealEstate> findByEmail(String email);

    RealEstate findByEmailEquals(String username);
}
