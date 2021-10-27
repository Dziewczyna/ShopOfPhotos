package pl.shopofphotos.shopofphotos.domain.photo;

import pl.shopofphotos.shopofphotos.domain.camera.Camera;
import pl.shopofphotos.shopofphotos.domain.resolution.Resolution;

public class PhotoTechnicalDetails {
  private final Camera camera;
  private final Resolution resolution;

  public PhotoTechnicalDetails(Camera camera, Resolution resolution) {
    this.camera = camera;
    this.resolution = resolution;
  }

  @Override
  public String toString() {
    return "PhotoTechnicalDetails{" + "camera=" + camera + ", resolution=" + resolution + '}';
  }
}
