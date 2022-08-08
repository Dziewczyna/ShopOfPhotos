package pl.shopofphotos.shopofphotos.service.camera;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.shopofphotos.shopofphotos.domain.camera.CameraJpaRepository;
import pl.shopofphotos.shopofphotos.domain.camera.NoCameraException;
import pl.shopofphotos.shopofphotos.domain.camera.entity.CameraEntity;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class CameraService {
  @Autowired private CameraJpaRepository cameraJpaRepository;

  public List<CameraEntity> getCameras() {
    return cameraJpaRepository.findAll();
  }

  public CameraEntity getCamera(long cameraId) {
    Optional<CameraEntity> cameraEntity = cameraJpaRepository.findById(cameraId);
    if (cameraEntity.isEmpty()) {
      throw new NoCameraException("No camera with id " + cameraId);
    }
    return cameraEntity.get();
  }

  public long addCamera(CameraEntity cameraEntity) {
    return cameraJpaRepository.save(cameraEntity).getCameraId();
  }

  public void deleteAllCameras() {
    cameraJpaRepository.deleteAll();
  }
}
