package pl.shopofphotos.shopofphotos.service.camera;

import org.springframework.stereotype.Service;
import pl.shopofphotos.shopofphotos.domain.camera.Camera;
import pl.shopofphotos.shopofphotos.domain.camera.CameraJpaRepository;
import pl.shopofphotos.shopofphotos.domain.camera.NoCameraException;

import java.util.List;
import java.util.Optional;

@Service
public class CameraService {
  private CameraJpaRepository cameraJpaRepository;

  public List<Camera> getCameras() {
    return cameraJpaRepository.findAll();
  }

  public Camera getCamera(String cameraId) {
    Optional<Camera> camera = cameraJpaRepository.findById(cameraId);
    if (camera.isEmpty()) {
      throw new NoCameraException("No camera with id " + cameraId);
    }
    return camera.get();
  }
}
