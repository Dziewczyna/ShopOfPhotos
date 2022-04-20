package pl.shopofphotos.shopofphotos.domain.photo;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.shopofphotos.shopofphotos.domain.photo.entity.PhotoEntity;

public interface PhotoJpaRepository extends JpaRepository<PhotoEntity, String> {}
