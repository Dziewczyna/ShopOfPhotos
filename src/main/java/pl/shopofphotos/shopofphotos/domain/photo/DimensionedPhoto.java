package pl.shopofphotos.shopofphotos.domain.photo;

import pl.shopofphotos.shopofphotos.domain.dimension.Dimension;

public class DimensionedPhoto extends Photo {
  private final Photo photo;
  private Dimension dimension;

  public DimensionedPhoto(Dimension dimension, Photo photo) {
    super(
        photo.getPrice(),
        photo.getAuthorNumber(),
        photo.getPhotoDetails(),
        photo.getPhotoTechnicalDetails());
    this.dimension = dimension;
    this.photo = photo;
  }

  public void setDimension(Dimension dimension) {
    this.dimension = dimension;
  }
}
