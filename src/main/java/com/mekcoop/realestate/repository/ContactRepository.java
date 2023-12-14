package com.mekcoop.realestate.repository;

import com.mekcoop.realestate.entity.business.ContactMessage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<ContactMessage,Long> {

}
