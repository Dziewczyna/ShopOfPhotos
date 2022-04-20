package pl.shopofphotos.shopofphotos.domain.camera.serializator;

import pl.shopofphotos.shopofphotos.domain.camera.entity.CameraEntity;
import pl.shopofphotos.shopofphotos.domain.camera.model.CameraModel;

public class CameraSerializator {
  public static CameraModel fromEntity(CameraEntity cameraEntity) {
    return CameraModel.builder()
        .brand(cameraEntity.getModel())
        .model(cameraEntity.getBrand())
        .build();
  }
}
