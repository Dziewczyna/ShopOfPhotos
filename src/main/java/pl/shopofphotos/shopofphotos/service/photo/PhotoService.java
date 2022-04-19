package pl.shopofphotos.shopofphotos.service.photo;

import org.springframework.stereotype.Service;
import pl.shopofphotos.shopofphotos.domain.photo.NoPhotoException;
import pl.shopofphotos.shopofphotos.domain.photo.entities.PhotoEntity;
import pl.shopofphotos.shopofphotos.domain.photo.PhotoJpaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PhotoService {
  private PhotoJpaRepository photoJpaRepository;

  public List<PhotoEntity> getPhotos() {
    return photoJpaRepository.findAll();
  }

  public PhotoEntity getPhoto(String photoId) {
    Optional<PhotoEntity> photo = photoJpaRepository.findById(photoId);
    if (photo.isEmpty()) {
      throw new NoPhotoException("No photo with id " + photoId);
    }
    return photo.get();
  }
}
