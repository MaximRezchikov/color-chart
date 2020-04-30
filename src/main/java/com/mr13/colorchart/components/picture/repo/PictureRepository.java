package com.mr13.colorchart.components.picture.repo;

import com.mr13.colorchart.components.picture.domain.Picture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PictureRepository extends JpaRepository<Picture, Long> {

  Picture getByName(String name);
}
