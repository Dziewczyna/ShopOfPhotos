package pl.shopofphotos.shopofphotos.domain.photo;

import pl.shopofphotos.shopofphotos.domain.dimension.Dimension;
import pl.shopofphotos.shopofphotos.domain.photo.entity.PhotoEntity;

public class DimensionedPhoto extends PhotoEntity {
  private final PhotoEntity photo;
  private Dimension dimension;

  public DimensionedPhoto(Dimension dimension, PhotoEntity photo) {
    super(
        photo.getPhotoId(),
        photo.getPrice(),
        photo.getAuthorId(),
        photo.getPhotoDetails(),
        photo.getCameraEntity(),
        photo.getResolution(),
        photo.getPlaceOfPhoto(),
        photo.getCategory());
    this.dimension = dimension;
    this.photo = photo;
  }

  public void setDimension(Dimension dimension) {
    this.dimension = dimension;
  }
}
