package pl.shopofphotos.shopofphotos.domain.photo.serializator;

import pl.shopofphotos.shopofphotos.domain.PlaceOfPhoto;
import pl.shopofphotos.shopofphotos.domain.camera.serializator.CameraSerializator;
import pl.shopofphotos.shopofphotos.domain.photo.PhotoDetails;
import pl.shopofphotos.shopofphotos.domain.photo.PhotoTechnicalDetails;
import pl.shopofphotos.shopofphotos.domain.photo.entity.PhotoEntity;
import pl.shopofphotos.shopofphotos.domain.photo.model.PhotoModel;
import pl.shopofphotos.shopofphotos.domain.price.serializator.PriceSerializator;

public class PhotoSerializator {

  public static PhotoModel fromEntity(PhotoEntity photoEntity) {
    return PhotoModel.builder()
        .authorNumber(photoEntity.getAuthorId())
        .price(PriceSerializator.fromEntity(photoEntity.getPrice()))
        .photoDetails(
            new PhotoDetails(
                new PlaceOfPhoto(photoEntity.getPlaceOfPhoto()), photoEntity.getCategory()))
        .photoTechnicalDetails(
            new PhotoTechnicalDetails(
                CameraSerializator.fromEntity(photoEntity.getCameraEntity()),
                photoEntity.getResolution()))
        .build();
  }
}
