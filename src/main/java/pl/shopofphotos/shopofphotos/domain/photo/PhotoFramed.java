package pl.shopofphotos.shopofphotos.domain.photo;

public class PhotoFramed extends Photo {
  private final Photo photo;
  private Frame frame;

  public PhotoFramed(Frame frame, Photo photo) {
    super(
        photo.getPrice(),
        photo.getAuthor(),
        photo.getPhotoDetails(),
        photo.getPhotoTechnicalDetails());
    this.frame = frame;
    this.photo = photo;
  }

  public void setFrame(Frame frame) {
    this.frame = frame;
  }
}
