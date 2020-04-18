package com.mr13.colorchart.components.upload.repo;

import com.mr13.colorchart.components.upload.domain.File;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileRepository extends JpaRepository<File, Long> {

}
