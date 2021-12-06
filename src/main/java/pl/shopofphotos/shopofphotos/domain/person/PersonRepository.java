package pl.shopofphotos.shopofphotos.domain.person;

public interface PersonRepository {
  String addPerson(String firstName, String lastName, Address address);

  void readPersons();

  Person editPerson(String firstName, String lastName, String address);

  void deletePerson(String firstName, String lastName, Address address);
}
