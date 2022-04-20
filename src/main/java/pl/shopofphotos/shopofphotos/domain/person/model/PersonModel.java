package pl.shopofphotos.shopofphotos.domain.person.model;

import lombok.Builder;
import pl.shopofphotos.shopofphotos.domain.person.Address;

@Builder
public class PersonModel {
  private final String firstName;
  private final String lastName;
  private final Address address;

  public PersonModel(String firstName, String lastName, Address address) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.address = address;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public Address getAddress() {
    return address;
  }

  @Override
  public String toString() {
    return "PersonModel{"
        + "firstName='"
        + firstName
        + '\''
        + ", lastName='"
        + lastName
        + '\''
        + ", address="
        + address
        + '}';
  }
}
