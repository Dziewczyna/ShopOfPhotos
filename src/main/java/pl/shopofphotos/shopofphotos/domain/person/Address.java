package pl.shopofphotos.shopofphotos.domain.person;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Address {
  private String street;
  private String city;
  private String state;
  private String postalCode;
  private Country country;

  @Override
  public String toString() {
    return "Address{"
        + "street='"
        + street
        + '\''
        + ", city='"
        + city
        + '\''
        + ", state='"
        + state
        + '\''
        + ", postalCode='"
        + postalCode
        + '\''
        + ", country="
        + country
        + '}';
  }
}
