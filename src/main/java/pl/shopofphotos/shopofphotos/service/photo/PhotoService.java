package pl.shopofphotos.shopofphotos.service.photo;

import org.springframework.stereotype.Service;
import pl.shopofphotos.shopofphotos.domain.photo.NoPhotoException;
import pl.shopofphotos.shopofphotos.domain.photo.Photo;
import pl.shopofphotos.shopofphotos.domain.photo.PhotoJpaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PhotoService {
  private PhotoJpaRepository photoJpaRepository;

  public List<Photo> getPhotos() {
    return photoJpaRepository.findAll();
  }

  public Photo getPhoto(String photoId) {
    Optional<Photo> photo = photoJpaRepository.findById(photoId);
    if (photo.isEmpty()) {
      throw new NoPhotoException("No photo with id " + photoId);
    }
    return photo.get();
  }
}
