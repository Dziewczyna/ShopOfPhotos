package pl.shopofphotos.shopofphotos.domain.address;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.shopofphotos.shopofphotos.domain.address.entity.AddressEntity;

@Repository
public interface AddressJpaRepository extends JpaRepository<AddressEntity, Long> {}
