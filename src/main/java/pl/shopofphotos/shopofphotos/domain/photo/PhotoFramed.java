package pl.shopofphotos.shopofphotos.domain.photo;

import pl.shopofphotos.shopofphotos.domain.photo.entity.PhotoEntity;

public class PhotoFramed extends PhotoEntity {
  private final PhotoEntity photo;
  private Frame frame;

  public PhotoFramed(Frame frame, PhotoEntity photo) {
    super(
        photo.getPhotoId(),
        photo.getPrice(),
        photo.getAuthorId(),
        photo.getPhotoDetails(),
        photo.getCameraEntity(),
        photo.getResolution(),
        photo.getPlaceOfPhoto(),
        photo.getCategory());
    this.frame = frame;
    this.photo = photo;
  }

  public void setFrame(Frame frame) {
    this.frame = frame;
  }
}
