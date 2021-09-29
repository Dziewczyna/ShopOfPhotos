package pl.shopofphotos.shopofphotos.domain.photo;

import pl.shopofphotos.shopofphotos.domain.Category;
import pl.shopofphotos.shopofphotos.domain.PlaceOfPhoto;
import pl.shopofphotos.shopofphotos.domain.camera.Camera;
import pl.shopofphotos.shopofphotos.domain.dimension.Dimension;
import pl.shopofphotos.shopofphotos.domain.person.Person;
import pl.shopofphotos.shopofphotos.domain.price.Price;
import pl.shopofphotos.shopofphotos.domain.resolution.Resolution;

public class DimensionedPhoto extends Photo {
  private Dimension dimension;

  public DimensionedPhoto(
      Camera camera,
      Resolution resolution,
      PlaceOfPhoto placeOfPhoto,
      Category category,
      Price price,
      Person author,
      Dimension dimension) {
    super(camera, resolution, placeOfPhoto, category, price, author);
    this.dimension = dimension;
  }

  public void setDimension(Dimension dimension) {
    this.dimension = dimension;
  }
}
