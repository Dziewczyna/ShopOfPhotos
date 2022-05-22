package pl.shopofphotos.shopofphotos.domain.photo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pl.shopofphotos.shopofphotos.domain.price.Price;

@NoArgsConstructor
@Getter
@AllArgsConstructor
public class Photo {
  private long photoId;
  private Price price;
  private String authorNumber;
  private PhotoDetails photoDetails;
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
