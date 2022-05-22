package pl.shopofphotos.shopofphotos;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.shopofphotos.shopofphotos.domain.Category;
import pl.shopofphotos.shopofphotos.domain.camera.entity.CameraEntity;
import pl.shopofphotos.shopofphotos.domain.photo.entity.PhotoEntity;
import pl.shopofphotos.shopofphotos.domain.price.Currency;
import pl.shopofphotos.shopofphotos.domain.price.entity.PriceEntity;
import pl.shopofphotos.shopofphotos.domain.resolution.Resolution;
import pl.shopofphotos.shopofphotos.service.photo.PhotoService;

@Service
@AllArgsConstructor
public class DataBaseAppService implements AppService {
  @Autowired private final PhotoService photoService;

  @Override
  public void runApp() {
    PriceEntity priceEntity = new PriceEntity("123.00", Currency.PLN);
    CameraEntity cameraEntity = new CameraEntity("canon", "e456");
    PhotoEntity photoEntity =
        new PhotoEntity(
            priceEntity,
            "Joasia",
            "details",
            cameraEntity,
            Resolution.resolution1051,
            "krakow",
            Category.ANIMALS);

    var photoIdGeneratedByDb = photoService.addPhoto(photoEntity);
    System.out.println(photoService.getPhotos().size());

    PhotoEntity photo = photoService.getPhoto(photoIdGeneratedByDb);
    System.out.println(photo);

    photoService.deleteAllPhotos();

    System.out.println(photoService.getPhotos().size());
  }
}
