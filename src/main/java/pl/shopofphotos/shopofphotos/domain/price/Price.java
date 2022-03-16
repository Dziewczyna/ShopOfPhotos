package pl.shopofphotos.shopofphotos.domain.price;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "price")
public class Price {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "price_id")
  private long price_id;

  @Column(name = "price_value")
  private BigDecimal price;

  @Column(name = "currency")
  private Currency currency;

  @Override
  public String toString() {
    return price + ";" + currency;
  }
}
