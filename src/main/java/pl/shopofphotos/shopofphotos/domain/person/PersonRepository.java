package pl.shopofphotos.shopofphotos.domain.person;

import pl.shopofphotos.shopofphotos.domain.address.Address;

public interface PersonRepository {
  void addPerson(String firstName, String lastName, Address address);

  void readPersons();

  String getPersonNumber(int i);

  String readPerson(String firstName, String lastName);

  void editPerson(String firstName, String lastName, Address address);

  void deletePerson(String firstName, String lastName);
}
