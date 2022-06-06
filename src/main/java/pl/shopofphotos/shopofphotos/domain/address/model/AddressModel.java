package pl.shopofphotos.shopofphotos.domain.address.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import pl.shopofphotos.shopofphotos.domain.address.Country;

@Builder
@AllArgsConstructor
@Getter
public class AddressModel {
  private final String street;
  private final String city;
  private final String state;
  private final String postalCode;
  private final Country country;

  @Override
  public String toString() {
    return "AddressModel{"
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
        + ", country='"
        + country
        + '\''
        + '}';
  }
}
