package com.mekcoop.realestate.repository;

import com.mekcoop.realestate.entity.user.concretes.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    boolean existsBySsn(String ssn);

    boolean existsByEmail(String email);

    boolean existsByPhoneNumber(String phoneNumber);


    Optional<User> findBySsn(String ssn);

    User findByEmailEquals(String email);

}
