package pl.shopofphotos.shopofphotos.domain.price;

public class NoPriceException extends IllegalStateException {
  public NoPriceException(String message) {
    super(message);
  }
}
