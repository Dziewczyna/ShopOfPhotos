package pl.shopofphotos.shopofphotos.domain.person;

public class NoPersonException extends IllegalStateException {
  public NoPersonException(String message) {
    super(message);
  }
}
