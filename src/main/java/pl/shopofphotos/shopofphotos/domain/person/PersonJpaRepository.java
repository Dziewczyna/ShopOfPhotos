package pl.shopofphotos.shopofphotos.domain.person;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.shopofphotos.shopofphotos.domain.person.entity.PersonEntity;

@Repository
public interface PersonJpaRepository extends JpaRepository<PersonEntity, String> {}
