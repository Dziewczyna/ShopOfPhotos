package pl.shopofphotos.shopofphotos.service.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.shopofphotos.shopofphotos.domain.person.NoPersonException;
import pl.shopofphotos.shopofphotos.domain.person.PersonJpaRepository;
import pl.shopofphotos.shopofphotos.domain.person.entity.PersonEntity;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {
  @Autowired private PersonJpaRepository personJpaRepository;

  public List<PersonEntity> getPersons() {
    return personJpaRepository.findAll();
  }

  public PersonEntity getPerson(long personId) {
    Optional<PersonEntity> personEntity = personJpaRepository.findById(personId);
    if (personEntity.isEmpty()) {
      throw new NoPersonException("No person with id " + personId);
    }
    return personEntity.get();
  }

  public long addPerson(PersonEntity personEntity) {
    return personJpaRepository.save(personEntity).getPersonId();
  }

  public void deleteAllPersons() {
    personJpaRepository.deleteAll();
  }
}
