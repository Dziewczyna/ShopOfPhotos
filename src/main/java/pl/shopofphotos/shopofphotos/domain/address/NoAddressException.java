package pl.shopofphotos.shopofphotos.domain.address;

public class NoAddressException extends IllegalStateException {
  public NoAddressException(String message) {
    super(message);
  }
}
