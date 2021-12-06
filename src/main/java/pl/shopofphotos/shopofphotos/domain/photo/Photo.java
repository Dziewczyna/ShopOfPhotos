package pl.shopofphotos.shopofphotos.domain.photo;

import pl.shopofphotos.shopofphotos.domain.price.Price;

public class Photo {
  private final Price price;
  private final String authorNumber;
  private final PhotoDetails photoDetails;
  private final PhotoTechnicalDetails photoTechnicalDetails;

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

  public Price getPrice() {
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
