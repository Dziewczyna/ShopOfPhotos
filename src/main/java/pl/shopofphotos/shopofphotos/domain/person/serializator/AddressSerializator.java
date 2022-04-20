package pl.shopofphotos.shopofphotos.domain.person.serializator;

import pl.shopofphotos.shopofphotos.domain.person.entity.AddressEntity;
import pl.shopofphotos.shopofphotos.domain.person.model.AddressModel;

public class AddressSerializator {

  public static AddressModel fromEntity(AddressEntity addressEntity) {
    return AddressModel.builder()
        .street(addressEntity.getStreet())
        .city(addressEntity.getCity())
        .state(addressEntity.getState())
        .postalCode(addressEntity.getPostalCode())
        .country(addressEntity.getCountry())
        .build();
  }
}
