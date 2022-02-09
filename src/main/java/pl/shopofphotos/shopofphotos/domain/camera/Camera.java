package pl.shopofphotos.shopofphotos.domain.camera;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "camera")
@AllArgsConstructor
@Getter
@NoArgsConstructor
public class Camera {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "camera_id")
  private long camera_id;

  @Column(name = "brand")
  private String brand;

  @Column(name = "model")
  private String model;

  @Override
  public String toString() {
    return "Camera{" + "brand='" + brand + '\'' + ", model='" + model + '\'' + '}';
  }
}
