package pl.shopofphotos.shopofphotos.domain.person;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Person {
  private String firstName;
  private String lastName;
  private Address address;

  @Override
  public String toString() {
    return firstName + ";" + lastName + ";" + address;
  }
}
