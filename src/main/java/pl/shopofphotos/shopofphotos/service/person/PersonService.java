package pl.shopofphotos.shopofphotos.service.person;

import org.springframework.stereotype.Service;
import pl.shopofphotos.shopofphotos.domain.person.NoPersonException;
import pl.shopofphotos.shopofphotos.domain.person.Person;
import pl.shopofphotos.shopofphotos.domain.person.PersonJpaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {
  private PersonJpaRepository personJpaRepository;

  public List<Person> getPersons() {
    return personJpaRepository.findAll();
  }

  public Person getPerson(String personId) {
    Optional<Person> person = personJpaRepository.findById(personId);
    if (person.isEmpty()) {
      throw new NoPersonException("No person with id " + personId);
    }
    return person.get();
  }
}
