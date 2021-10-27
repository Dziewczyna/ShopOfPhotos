package pl.shopofphotos.shopofphotos.domain.photo;

import pl.shopofphotos.shopofphotos.domain.Category;
import pl.shopofphotos.shopofphotos.domain.PlaceOfPhoto;

public class PhotoDetails {
  private final PlaceOfPhoto placeOfPhoto;
  private final Category category;

  public PhotoDetails(PlaceOfPhoto placeOfPhoto, Category category) {
    this.placeOfPhoto = placeOfPhoto;
    this.category = category;
  }

  @Override
  public String toString() {
    return "PhotoDetails{" + "placeOfPhoto=" + placeOfPhoto + ", category=" + category + '}';
  }
}
