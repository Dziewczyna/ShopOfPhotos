package pl.shopofphotos.shopofphotos.domain.camera.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "camera")
@AllArgsConstructor
@Getter
@NoArgsConstructor
public class CameraEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hibernate_sequence")
  @SequenceGenerator(name = "hibernate_sequence", allocationSize = 1)
  @Column(name = "camera_id")
  private long cameraId;

  @Column(name = "brand")
  private String brand;

  @Column(name = "model")
  private String model;

  public CameraEntity(String brand, String model) {
    this.brand = brand;
    this.model = model;
  }

  @Override
  public String toString() {
    return "Camera{" + "brand='" + brand + '\'' + ", model='" + model + '\'' + '}';
  }
}
