package pl.shopofphotos.shopofphotos.domain.order.serializator;

import pl.shopofphotos.shopofphotos.domain.order.entity.OrderEntity;
import pl.shopofphotos.shopofphotos.domain.order.model.OrderModel;
import pl.shopofphotos.shopofphotos.domain.person.serializator.PersonSerializator;
import pl.shopofphotos.shopofphotos.domain.price.serializator.PriceSerializator;

public class OrderSerializator {

  public static OrderModel fromEntity(OrderEntity orderEntity) {
    return OrderModel.builder()
        .buyer(PersonSerializator.fromEntity(orderEntity.getBuyerId()))
        .author(PersonSerializator.fromEntity(orderEntity.getAuthorId()))
        .price(PriceSerializator.fromEntity(orderEntity.getPrice()))
        .build();
  }
}
