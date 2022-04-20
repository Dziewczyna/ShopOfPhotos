package pl.shopofphotos.shopofphotos.service.camera;

import org.springframework.stereotype.Service;
import pl.shopofphotos.shopofphotos.domain.camera.entity.CameraEntity;
import pl.shopofphotos.shopofphotos.domain.camera.CameraJpaRepository;
import pl.shopofphotos.shopofphotos.domain.camera.NoCameraException;

import java.util.List;
import java.util.Optional;

@Service
public class CameraService {
  private CameraJpaRepository cameraJpaRepository;

  public List<CameraEntity> getCameras() {
    return cameraJpaRepository.findAll();
  }

  public CameraEntity getCamera(String cameraId) {
    Optional<CameraEntity> camera = cameraJpaRepository.findById(cameraId);
    if (camera.isEmpty()) {
      throw new NoCameraException("No camera with id " + cameraId);
    }
    return camera.get();
  }
}
