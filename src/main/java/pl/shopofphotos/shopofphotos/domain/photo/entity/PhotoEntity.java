package pl.shopofphotos.shopofphotos.domain.photo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pl.shopofphotos.shopofphotos.domain.Category;
import pl.shopofphotos.shopofphotos.domain.camera.model.CameraModel;
import pl.shopofphotos.shopofphotos.domain.price.Price;
import pl.shopofphotos.shopofphotos.domain.resolution.Resolution;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Table(name = "photo")
@Getter
@AllArgsConstructor
public class PhotoEntity {
  @Id
  @Column(name = "photo_id")
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long photoId;

  @OneToOne(cascade = CascadeType.MERGE)
  @JoinColumn(name = "price_id", referencedColumnName = "price_id")
  private Price price;

  @Column(name = "author_id")
  private String authorId;

  @Column(name = "photo_details")
  private String photoDetails;

  @OneToOne(cascade = CascadeType.MERGE)
  @JoinColumn(name = "camera_id", referencedColumnName = "camera_id")
  private CameraModel cameraModel;

  @Column(name = "resolution")
  private Resolution resolution;

  @Column(name = "place_of_photo")
  private String placeOfPhoto;

  @Column(name = "category")
  private Category category;

  public PhotoEntity(
      Price price,
      String authorId,
      String photoDetails,
      CameraModel cameraModel,
      Resolution resolution,
      String placeOfPhoto,
      Category category) {
    this.price = price;
    this.authorId = authorId;
    this.photoDetails = photoDetails;
    this.cameraModel = cameraModel;
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
        + cameraModel
        + '}';
  }
}
