package pl.shopofphotos.shopofphotos.domain.price;

public enum Currency {
  PLN("PLN"),
  USD("USD"),
  EUR("EURO"),
  BTC("BITCOIN");

  private final String currency;

  Currency(String currency) {
    this.currency = currency;
  }

  public String getCurrency() {
    return currency;
  }

  @Override
  public String toString() {
    return "" + currency + '\'';
  }
}
