package pl.shopofphotos.shopofphotos.domain.price;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.shopofphotos.shopofphotos.domain.price.entity.PriceEntity;

@Repository
public interface PriceJpaRepository extends JpaRepository<PriceEntity, Long> {}
