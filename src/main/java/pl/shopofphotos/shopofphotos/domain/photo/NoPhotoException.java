package pl.shopofphotos.shopofphotos.domain.photo;

public class NoPhotoException extends IllegalStateException {
  public NoPhotoException(String message) {
    super(message);
  }
}
