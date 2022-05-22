package pl.shopofphotos.shopofphotos.domain.photo;

import lombok.Getter;
import pl.shopofphotos.shopofphotos.domain.camera.model.CameraModel;
import pl.shopofphotos.shopofphotos.domain.resolution.Resolution;

@Getter
public class PhotoTechnicalDetails {
  private final CameraModel cameraModel;
  private final Resolution resolution;

  public PhotoTechnicalDetails(CameraModel cameraModel, Resolution resolution) {
    this.cameraModel = cameraModel;
    this.resolution = resolution;
  }

  @Override
  public String toString() {
    return "PhotoTechnicalDetails{" + "camera=" + cameraModel + ", resolution=" + resolution + '}';
  }
}
