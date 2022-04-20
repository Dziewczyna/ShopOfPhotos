package pl.shopofphotos.shopofphotos.domain.price.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import pl.shopofphotos.shopofphotos.domain.price.Currency;

import java.math.BigDecimal;

@Builder
@AllArgsConstructor
@Getter
public class PriceModel {
    private final BigDecimal price;
    private final Currency currency;

    @Override
    public String toString() {
        return "PriceModel{" +
                "price=" + price +
                ", currency=" + currency +
                '}';
    }
}
