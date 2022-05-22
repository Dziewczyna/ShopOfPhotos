package pl.shopofphotos.shopofphotos.domain.photo;

import pl.shopofphotos.shopofphotos.domain.price.entity.PriceEntity;

public interface PhotoRepository {
  void addPhoto(
      PriceEntity price,
      String authorNumber,
      PhotoDetails photoDetails,
      PhotoTechnicalDetails photoTechnicalDetails);

  void editPhoto(
      String photoNumber,
      PriceEntity price,
      String authorNumber,
      PhotoDetails photoDetails,
      PhotoTechnicalDetails photoTechnicalDetails);

  PriceEntity changePriceOfPhoto(String photoNumber, PriceEntity price);

  String readPhoto(String photoNumber);

  void deletePhoto(String photoNumber);
}
