package com.mr13.colorchart.components.upload.service;

import com.mr13.colorchart.components.upload.domain.File;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface FileService {

  File getById(Long fileId);

  List<File> getAllFiles();

  void uploadFile(MultipartFile file);
}
