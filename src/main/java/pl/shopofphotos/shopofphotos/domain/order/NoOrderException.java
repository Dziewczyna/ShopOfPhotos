package pl.shopofphotos.shopofphotos.domain.order;

public class NoOrderException extends IllegalStateException {
  public NoOrderException(String message) {
    super(message);
  }
}
