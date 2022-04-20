package pl.shopofphotos.shopofphotos.domain.person.serializator;

import pl.shopofphotos.shopofphotos.domain.person.Address;
import pl.shopofphotos.shopofphotos.domain.person.entity.PersonEntity;
import pl.shopofphotos.shopofphotos.domain.person.model.PersonModel;

public class PersonSerializator {

  public static PersonModel fromEntity(PersonEntity personEntity) {
    return PersonModel.builder()
        .firstName(personEntity.getFirstName())
        .lastName(personEntity.getLastName())
        .address(
            new Address(
                personEntity.getAddress(),
                personEntity.getStreet(),
                personEntity.getCity(),
                personEntity.getState(),
                personEntity.getPostalCode(),
                personEntity.getCountry()))
        .build();
  }
}
