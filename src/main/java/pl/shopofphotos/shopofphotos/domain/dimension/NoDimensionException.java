package pl.shopofphotos.shopofphotos.domain.dimension;

public class NoDimensionException extends IllegalStateException {
  public NoDimensionException(String message) {
    super(message);
  }
}
