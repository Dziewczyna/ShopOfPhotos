package pl.shopofphotos.shopofphotos.domain.camera;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.shopofphotos.shopofphotos.domain.camera.entity.CameraEntity;

@Repository
public interface CameraJpaRepository extends JpaRepository<CameraEntity, String> {}
