package pl.shopofphotos.shopofphotos.domain.photo;

import pl.shopofphotos.shopofphotos.domain.Category;
import pl.shopofphotos.shopofphotos.domain.PlaceOfPhoto;
import pl.shopofphotos.shopofphotos.domain.camera.Camera;
import pl.shopofphotos.shopofphotos.domain.person.Person;
import pl.shopofphotos.shopofphotos.domain.price.Price;
import pl.shopofphotos.shopofphotos.domain.resolution.Resolution;

public class PhotoFramed extends Photo {
  private final Frame frame;

  public PhotoFramed(
      Camera camera,
      Resolution resolution,
      PlaceOfPhoto placeOfPhoto,
      Category category,
      Price price,
      Person author,
      Frame frame) {
    super(camera, resolution, placeOfPhoto, category, price, author);
    this.frame = frame;
  }
}
