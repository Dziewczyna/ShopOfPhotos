package pl.shopofphotos.shopofphotos.domain.photo;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.shopofphotos.shopofphotos.domain.price.Price;

public interface PhotoRepository{
  void addPhoto(
      Price price,
      String authorNumber,
      PhotoDetails photoDetails,
      PhotoTechnicalDetails photoTechnicalDetails);

  void editPhoto(
      String photoNumber,
      Price price,
      String authorNumber,
      PhotoDetails photoDetails,
      PhotoTechnicalDetails photoTechnicalDetails);

  Price changePriceOfPhoto(String photoNumber, Price price);

  String readPhoto(String photoNumber);

  void deletePhoto(String photoNumber);
}
