package pl.shopofphotos.shopofphotos.domain.camera.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@AllArgsConstructor
@Getter
public class CameraModel {
  private final String brand;
  private final String model;

  @Override
  public String toString() {
    return "CameraModel{" + "brand='" + brand + '\'' + ", model='" + model + '\'' + '}';
  }
}
