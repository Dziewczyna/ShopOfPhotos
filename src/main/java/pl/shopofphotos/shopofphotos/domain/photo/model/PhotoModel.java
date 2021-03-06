package pl.shopofphotos.shopofphotos.domain.photo.model;

import lombok.Builder;
import pl.shopofphotos.shopofphotos.domain.photo.PhotoDetails;
import pl.shopofphotos.shopofphotos.domain.photo.PhotoTechnicalDetails;
import pl.shopofphotos.shopofphotos.domain.price.model.PriceModel;

@Builder
public class PhotoModel {
  private final PriceModel price;
  private final String authorNumber;
  private final PhotoDetails photoDetails;
  private final PhotoTechnicalDetails photoTechnicalDetails;

  public PhotoModel(
      PriceModel price,
      String authorNumber,
      PhotoDetails photoDetails,
      PhotoTechnicalDetails photoTechnicalDetails) {
    this.price = price;
    this.authorNumber = authorNumber;
    this.photoDetails = photoDetails;
    this.photoTechnicalDetails = photoTechnicalDetails;
  }

  public PriceModel getPrice() {
    return price;
  }

  public String getAuthorNumber() {
    return authorNumber;
  }

  public PhotoDetails getPhotoDetails() {
    return photoDetails;
  }

  public PhotoTechnicalDetails getPhotoTechnicalDetails() {
    return photoTechnicalDetails;
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
