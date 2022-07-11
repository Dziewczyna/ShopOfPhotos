package pl.shopofphotos.shopofphotos.domain.address.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import pl.shopofphotos.shopofphotos.domain.address.Country;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Table(name = "address")
@Getter
public class AddressEntity {
  @Id
  @Column(name = "address_id")
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private long addressId;

  @Column(name = "street")
  private String street;

  @Column(name = "city")
  private String city;

  @Column(name = "state")
  private String state;

  @Column(name = "postal_code")
  private String postalCode;

  @Column(name = "country")
  private Country country;

  public AddressEntity(
      long addressId,
      String street,
      String city,
      String state,
      String postalCode,
      Country country) {
    this.addressId = addressId;
    this.street = street;
    this.city = city;
    this.state = state;
    this.postalCode = postalCode;
    this.country = country;
  }

  @Override
  public String toString() {
    return "AddressEntity{"
        + "addressId="
        + addressId
        + ", street='"
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
