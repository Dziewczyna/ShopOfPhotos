package pl.shopofphotos.shopofphotos.domain.photo;

import pl.shopofphotos.shopofphotos.domain.order.Order;
import pl.shopofphotos.shopofphotos.domain.person.Person;
import pl.shopofphotos.shopofphotos.domain.price.Price;

public interface PhotoRepository {
  boolean addPhoto(
      Price price,
      Person author,
      PhotoDetails photoDetails,
      PhotoTechnicalDetails photoTechnicalDetails);

  Photo editPhoto(Photo photo);

  Price changePhoto(Price price);

  Order readPhoto(int photoId);

  void deletePhoto(int photoId);
}
