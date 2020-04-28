package com.mr13.colorchart.components.picture.service;

import com.mr13.colorchart.components.picture.domain.File;
import com.mr13.colorchart.components.picture.repo.FileRepository;
import com.mr13.colorchart.core.service.CommonService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FilServiceImpl extends CommonService<File> implements FileService {

  private final FileRepository fileRepository;

  @Override
  @Transactional
  @SneakyThrows
  public void uploadFile(MultipartFile file) {

    byte[] bytes = file.getBytes();

    File fileToSave = File.builder()
        .file(bytes)
        .build();

    fileRepository.save(fileToSave);
  }

  @Override
  public File getOne(Long entityId) {
    return super.getOne(entityId);
  }

  @Override
  public List<File> getAll() {
    return super.getAll();
  }

  @Override
  public File delete(Long entityId) {
    return super.delete(entityId);
  }

  @Override
  public JpaRepository<File, Long> getRepository() {
    return fileRepository;
  }
}
