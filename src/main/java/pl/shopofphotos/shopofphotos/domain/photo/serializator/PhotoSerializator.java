package pl.shopofphotos.shopofphotos.domain.photo.serializator;

import pl.shopofphotos.shopofphotos.domain.PlaceOfPhoto;
import pl.shopofphotos.shopofphotos.domain.photo.PhotoDetails;
import pl.shopofphotos.shopofphotos.domain.photo.PhotoTechnicalDetails;
import pl.shopofphotos.shopofphotos.domain.photo.entity.PhotoEntity;
import pl.shopofphotos.shopofphotos.domain.photo.model.PhotoModel;

public class PhotoSerializator {

  public static PhotoModel fromEntity(PhotoEntity photoEntity) {
    return PhotoModel.builder()
        .authorNumber(photoEntity.getAuthorNumber())
        .price(photoEntity.getPrice())
        .photoDetails(
            new PhotoDetails(
                new PlaceOfPhoto(photoEntity.getPlaceOfPhoto()), photoEntity.getCategory()))
        .photoTechnicalDetails(
            new PhotoTechnicalDetails(photoEntity.getCameraEntity(), photoEntity.getResolution()))
        .build();
  }
}
