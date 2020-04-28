package com.mr13.colorchart.components.picture.repo;

import com.mr13.colorchart.components.picture.domain.File;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileRepository extends JpaRepository<File, Long> {

}
