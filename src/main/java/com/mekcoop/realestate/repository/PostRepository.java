package com.mekcoop.realestate.repository;

import com.mekcoop.realestate.entity.business.Post;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;



public interface PostRepository extends JpaRepository<Post,Long> {

    @Query("SELECT p FROM Post p WHERE (p.estateType = ?1 OR ?1 IS NULL) AND (p.price >= ?2 OR ?2 IS NULL) AND (p.price <= ?3 OR ?3 IS NULL) AND (p.roomNumber = ?4 OR ?4 IS NULL) AND (p.city = ?5 OR ?5 IS NULL)")
    Page<Post> findAllWithProperties(Pageable pageable, String estateType, Double minPrice, Double maxPrice, Integer roomNumber, String city);}
