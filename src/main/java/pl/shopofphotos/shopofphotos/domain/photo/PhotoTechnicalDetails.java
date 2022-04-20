package pl.shopofphotos.shopofphotos.domain.photo;

import pl.shopofphotos.shopofphotos.domain.camera.entity.CameraEntity;
import pl.shopofphotos.shopofphotos.domain.resolution.Resolution;

public class PhotoTechnicalDetails {
  private final CameraEntity cameraEntity;
  private final Resolution resolution;

  public PhotoTechnicalDetails(CameraEntity cameraEntity, Resolution resolution) {
    this.cameraEntity = cameraEntity;
    this.resolution = resolution;
  }

  @Override
  public String toString() {
    return "PhotoTechnicalDetails{" + "camera=" + cameraEntity + ", resolution=" + resolution + '}';
  }
}
