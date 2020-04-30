package com.mr13.colorchart.components.picture.service;

import com.mr13.colorchart.components.picture.domain.Picture;
import com.mr13.colorchart.components.picture.dto.PictureForm;
import com.mr13.colorchart.components.picture.repo.PictureRepository;
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
public class PictureServiceImpl extends CommonService<Picture> implements PictureService {

  private final PictureRepository pictureRepository;

  @Override
  @Transactional
  @SneakyThrows
  public void uploadFile(PictureForm pictureForm) {

    MultipartFile pictureFile = pictureForm.getPicture();

    byte[] pictureBytes = pictureFile.getBytes();
    String pictureName = pictureFile.getOriginalFilename();

    Picture pictureToSave = Picture.builder()
        .picture(pictureBytes)
        .name(pictureName)
        .build();

    pictureRepository.save(pictureToSave);
  }

  @Override
  @Transactional
  public Picture getByName(String pictureName) {
    return pictureRepository.getByName(pictureName);
  }

  @Override
  @Transactional
  public Picture getOne(Long entityId) {
    return super.getOne(entityId);
  }

  @Override
  @Transactional
  public List<Picture> getAll() {
    return super.getAll();
  }

  @Override
  @Transactional
  public Picture delete(Long entityId) {
    return super.delete(entityId);
  }

  @Override
  public JpaRepository<Picture, Long> getRepository() {
    return pictureRepository;
  }
}
