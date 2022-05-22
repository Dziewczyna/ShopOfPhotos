package pl.shopofphotos.shopofphotos.service.photo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.shopofphotos.shopofphotos.domain.photo.NoPhotoException;
import pl.shopofphotos.shopofphotos.domain.photo.PhotoJpaRepository;
import pl.shopofphotos.shopofphotos.domain.photo.entity.PhotoEntity;

import java.util.List;
import java.util.Optional;

@Service
public class PhotoService {
  @Autowired private PhotoJpaRepository photoJpaRepository;

  public List<PhotoEntity> getPhotos() {
    return photoJpaRepository.findAll();
  }

  public PhotoEntity getPhoto(Long photoId) {
    Optional<PhotoEntity> photo = photoJpaRepository.findById(photoId);
    if (photo.isEmpty()) {
      throw new NoPhotoException("No photo with id " + photoId);
    }
    return photo.get();
  }

  public long addPhoto(PhotoEntity photoEntity) {
    return photoJpaRepository.save(photoEntity).getPhotoId();
  }

  public void deleteAllPhotos() {
    photoJpaRepository.deleteAll();
  }
}
