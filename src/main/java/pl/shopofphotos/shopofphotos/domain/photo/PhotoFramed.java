package pl.shopofphotos.shopofphotos.domain.photo;

import pl.shopofphotos.shopofphotos.domain.photo.entities.PhotoEntity;

public class PhotoFramed extends PhotoEntity {
  private final PhotoEntity photo;
  private Frame frame;

  public PhotoFramed(Frame frame, PhotoEntity photo) {
    super(
        photo.getPrice(),
        photo.getAuthorNumber(),
        photo.getPhotoDetails(),
        photo.getCamera(),
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
