package pl.shopofphotos.shopofphotos.domain.photo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pl.shopofphotos.shopofphotos.domain.Category;
import pl.shopofphotos.shopofphotos.domain.camera.entity.CameraEntity;
import pl.shopofphotos.shopofphotos.domain.order.entity.OrderEntity;
import pl.shopofphotos.shopofphotos.domain.price.entity.PriceEntity;
import pl.shopofphotos.shopofphotos.domain.resolution.Resolution;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@Table(name = "photo")
@Getter
@AllArgsConstructor
public class PhotoEntity {
  @ManyToMany(cascade = CascadeType.PERSIST)
  @JoinColumn(name = "order_id", referencedColumnName = "order_id")
  public List<OrderEntity> orders;
  @Id
  @Column(name = "photo_id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long photoId;
  @OneToOne(
      cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.DETACH},
      fetch = FetchType.EAGER)
  @JoinColumn(name = "price_id", referencedColumnName = "price_id", insertable = true)
  private PriceEntity price;
  @Column(name = "author_id")
  private String authorId;
  @Column(name = "photo_details")
  private String photoDetails;
  @OneToOne(
      cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.DETACH},
      fetch = FetchType.EAGER)
  @JoinColumn(name = "camera_id", referencedColumnName = "camera_id")
  private CameraEntity cameraEntity;
  @Column(name = "resolution")
  private Resolution resolution;
  @Column(name = "place_of_photo")
  private String placeOfPhoto;
  @Column(name = "category")
  private Category category;

  public PhotoEntity(
      PriceEntity price,
      String authorId,
      String photoDetails,
      CameraEntity cameraEntity,
      Resolution resolution,
      String placeOfPhoto,
      Category category) {
    this.price = price;
    this.authorId = authorId;
    this.photoDetails = photoDetails;
    this.cameraEntity = cameraEntity;
    this.resolution = resolution;
    this.placeOfPhoto = placeOfPhoto;
    this.category = category;
  }

  @Override
  public String toString() {
    return "Photo{"
        + "price="
        + price
        + ", authorNumber="
        + authorId
        + ", photoDetails="
        + photoDetails
        + ", photoTechnicalDetails="
        + cameraEntity
        + '}';
  }
}
