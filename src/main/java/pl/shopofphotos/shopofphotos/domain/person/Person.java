package pl.shopofphotos.shopofphotos.domain.person;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Person {
  private String firstName;
  private String lastName;
  private Address address;

  @Override
  public String toString() {
    return firstName + ";" + lastName + ";" + address;
  }
}
