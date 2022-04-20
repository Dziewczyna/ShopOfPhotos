package pl.shopofphotos.shopofphotos.domain.camera;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.shopofphotos.shopofphotos.domain.camera.entity.CameraEntity;

public interface CameraJpaRepository extends JpaRepository<CameraEntity, String> {}
