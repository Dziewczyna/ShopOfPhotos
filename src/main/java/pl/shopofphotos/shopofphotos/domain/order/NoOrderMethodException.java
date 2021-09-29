package pl.shopofphotos.shopofphotos.domain.order;

public class NoOrderMethodException extends IllegalStateException {
  public NoOrderMethodException(String message) {
    super(message);
  }
}
