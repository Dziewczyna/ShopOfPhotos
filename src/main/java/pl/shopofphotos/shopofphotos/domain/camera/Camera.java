package pl.shopofphotos.shopofphotos.domain.camera;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Camera {
  private String brand;
  private String model;

  @Override
  public String toString() {
    return "Camera{" + "brand='" + brand + '\'' + ", model='" + model + '\'' + '}';
  }
}
