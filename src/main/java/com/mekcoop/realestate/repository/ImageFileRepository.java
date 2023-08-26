package com.mekcoop.realestate.repository;

import com.mekcoop.realestate.entity.business.ImageFile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageFileRepository extends JpaRepository<ImageFile,Long> {
}
