package pl.shopofphotos.shopofphotos.domain.photo;

import pl.shopofphotos.shopofphotos.domain.person.Person;
import pl.shopofphotos.shopofphotos.domain.price.Price;

public class Photo {
  private final Price price;
  private final Person author;
  private final PhotoDetails photoDetails;
  private final PhotoTechnicalDetails photoTechnicalDetails;

  public Photo(
      Price price,
      Person author,
      PhotoDetails photoDetails,
      PhotoTechnicalDetails photoTechnicalDetails) {
    this.price = price;
    this.author = author;
    this.photoDetails = photoDetails;
    this.photoTechnicalDetails = photoTechnicalDetails;
  }

  public Price getPrice() {
    return price;
  }

  public Person getAuthor() {
    return author;
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
        + ", author="
        + author
        + ", photoDetails="
        + photoDetails
        + ", photoTechnicalDetails="
        + photoTechnicalDetails
        + '}';
  }
}
