package pl.shopofphotos.shopofphotos.domain.address;

public interface AddressRepository {
  void addAddress(String street, String city, String state, String postalCode, Country country);

  void readAddresses();

  String readAddress(String street, String city);

  void editAddress(String street, String city, String state, String postalCode, Country country);

  void deleteAddress(String street, String city);
}
