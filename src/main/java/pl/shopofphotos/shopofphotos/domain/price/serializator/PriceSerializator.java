package pl.shopofphotos.shopofphotos.domain.price.serializator;

import pl.shopofphotos.shopofphotos.domain.price.entity.PriceEntity;
import pl.shopofphotos.shopofphotos.domain.price.model.PriceModel;

import java.math.BigDecimal;

public class PriceSerializator {
  public static PriceModel fromEntity(PriceEntity priceEntity) {
    return PriceModel.builder()
        .currency(priceEntity.getCurrency())
        .price(new BigDecimal(priceEntity.getPrice()))
        .build();
  }
}
