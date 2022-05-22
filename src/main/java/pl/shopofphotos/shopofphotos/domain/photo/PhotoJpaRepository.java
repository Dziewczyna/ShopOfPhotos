package pl.shopofphotos.shopofphotos.domain.photo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.shopofphotos.shopofphotos.domain.photo.entity.PhotoEntity;

@Repository
public interface PhotoJpaRepository extends JpaRepository<PhotoEntity, Long> {}
