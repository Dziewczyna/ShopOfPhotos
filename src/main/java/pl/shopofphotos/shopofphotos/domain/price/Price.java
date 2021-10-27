package pl.shopofphotos.shopofphotos.domain.price;

import lombok.AllArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
public class Price {
  private BigDecimal price;
  private Currency currency;

  @Override
  public String toString() {
    return price + ";" + currency;
  }
}
