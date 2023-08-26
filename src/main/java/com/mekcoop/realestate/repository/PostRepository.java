package com.mekcoop.realestate.repository;

import com.mekcoop.realestate.entity.business.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post,Long> {
}
