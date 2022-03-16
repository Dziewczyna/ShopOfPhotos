package pl.shopofphotos.shopofphotos.domain.camera;

public class NoCameraException extends IllegalStateException {
  public NoCameraException(String message) {
    super(message);
  }
}
