package pl.shopofphotos.shopofphotos.domain.photo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pl.shopofphotos.shopofphotos.domain.price.Price;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Table(name = "photo")
@Getter
@AllArgsConstructor
public class Photo {
  @Id
  @Column(name = "photo_id")
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long photoId;

  @Column(name = "price")
  private Price price;

  @Column(name = "author_number")
  private String authorNumber;

  @Column(name = "photo_details")
  private PhotoDetails photoDetails;

  @Column(name = "photo_technical_details")
  private PhotoTechnicalDetails photoTechnicalDetails;

  public Photo(
      Price price,
      String authorNumber,
      PhotoDetails photoDetails,
      PhotoTechnicalDetails photoTechnicalDetails) {
    this.price = price;
    this.authorNumber = authorNumber;
    this.photoDetails = photoDetails;
    this.photoTechnicalDetails = photoTechnicalDetails;
  }

  @Override
  public String toString() {
    return "Photo{"
        + "price="
        + price
        + ", authorNumber="
        + authorNumber
        + ", photoDetails="
        + photoDetails
        + ", photoTechnicalDetails="
        + photoTechnicalDetails
        + '}';
  }
}
