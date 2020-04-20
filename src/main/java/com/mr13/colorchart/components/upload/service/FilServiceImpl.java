package com.mr13.colorchart.components.upload.service;

import com.mr13.colorchart.components.upload.domain.File;
import com.mr13.colorchart.components.upload.repo.FileRepository;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Base64;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FilServiceImpl implements FileService {

  private final FileRepository fileRepository;

  @Override
  public File getById(Long fileId) {
    return fileRepository.getOne(fileId);
  }

  @Override
  public List<File> getAllFiles() {
    return fileRepository.findAll();
  }

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
}
