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
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long priceId;

  @Column(name = "price")
  private String price;

  @Column(name = "currency")
  private Currency currency;

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
