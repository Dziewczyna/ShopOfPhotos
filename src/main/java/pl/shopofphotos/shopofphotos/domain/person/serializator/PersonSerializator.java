package pl.shopofphotos.shopofphotos.domain.person.serializator;

import pl.shopofphotos.shopofphotos.domain.address.Address;
import pl.shopofphotos.shopofphotos.domain.person.entity.PersonEntity;
import pl.shopofphotos.shopofphotos.domain.person.model.PersonModel;

public class PersonSerializator {

  public static PersonModel fromEntity(PersonEntity personEntity) {
    return PersonModel.builder()
        .firstName(personEntity.getFirstName())
        .lastName(personEntity.getLastName())
        .address(
            new Address(
                personEntity.getAddress().getAddressId(),
                personEntity.getAddress().getStreet(),
                personEntity.getAddress().getCity(),
                personEntity.getAddress().getState(),
                personEntity.getAddress().getPostalCode(),
                personEntity.getAddress().getCountry()))
        .build();
  }
}
