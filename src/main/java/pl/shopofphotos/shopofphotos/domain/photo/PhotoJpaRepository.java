package pl.shopofphotos.shopofphotos.domain.photo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PhotoJpaRepository extends JpaRepository<Photo, String> {}
