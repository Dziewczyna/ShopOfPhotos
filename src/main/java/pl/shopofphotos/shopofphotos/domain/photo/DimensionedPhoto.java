package pl.shopofphotos.shopofphotos.domain.photo;

import pl.shopofphotos.shopofphotos.domain.dimension.Dimension;

public class DimensionedPhoto extends Photo {
  private Dimension dimension;
  private final Photo photo;

  public DimensionedPhoto(Dimension dimension, Photo photo) {
    super(
        photo.getPrice(),
        photo.getAuthor(),
        photo.getPhotoDetails(),
        photo.getPhotoTechnicalDetails());
    this.dimension = dimension;
    this.photo = photo;
  }

  public void setDimension(Dimension dimension) {
    this.dimension = dimension;
  }
}
