package pl.shopofphotos.shopofphotos.domain.person;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Address {
  private String street;
  private String city;
  private String state;
  private String postalCode;
  private Country country;

  public Address(AddressBuilder addressBuilder) {
    this.street = addressBuilder.street;
    this.city = addressBuilder.city;
    this.state = addressBuilder.state;
    this.postalCode = addressBuilder.postalCode;
    this.country = addressBuilder.country;
  }

  @Override
  public String toString() {
    return "ul." + street + "; " + city + "; " + state + "; " + postalCode + "; " + country;
  }

  public static class AddressBuilder {
    private String street;
    private String city;
    private String state;
    private String postalCode;
    private Country country;

    public AddressBuilder street(String street) {
      this.street = street;
      return this;
    }

    public AddressBuilder city(String city) {
      this.city = city;
      return this;
    }

    public AddressBuilder state(String state) {
      this.state = state;
      return this;
    }

    public AddressBuilder postalCode(String postalCode) {
      this.postalCode = postalCode;
      return this;
    }

    public AddressBuilder country(Country country) {
      this.country = country;
      return this;
    }

    public Address build() {
      return new Address(this);
    }
  }
}
