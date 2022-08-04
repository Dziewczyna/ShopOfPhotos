package pl.shopofphotos.shopofphotos.domain.price.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pl.shopofphotos.shopofphotos.domain.price.Currency;

import javax.persistence.*;

@Entity
@Table(name = "price")
@NoArgsConstructor
@Getter
@AllArgsConstructor
public class PriceEntity {
  @Id
  @Column(name = "price_id")
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hibernate_sequence")
  private long priceId;

  @Column(name = "price")
  private String price;

  @Column(name = "currency")
  @Enumerated(EnumType.STRING)
  private Currency currency;

  public PriceEntity(String price, Currency currency) {
    this.currency = currency;
    this.price = price;
  }

  @Override
  public String toString() {
    return "PriceEntity{"
        + "priceId="
        + priceId
        + ", price='"
        + price
        + '\''
        + ", currency="
        + currency
        + '}';
  }
}
