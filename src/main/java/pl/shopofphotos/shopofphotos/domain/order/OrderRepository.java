package pl.shopofphotos.shopofphotos.domain.order;

import pl.shopofphotos.shopofphotos.domain.photo.entity.PhotoEntity;
import pl.shopofphotos.shopofphotos.domain.price.Price;

import java.util.List;

public interface OrderRepository {
  void placeOrder(
      String buyerNumber,
      String authorNumber,
      List<PhotoEntity> photos,
      Price price,
      OrderMethod orderMethod);

  PhotoEntity editPhoto(PhotoEntity photo);

  Price changePrice(String orderNumber, Price price);

  String readOrder(String orderNumber);

  void deleteOrder(String orderNumber);
}
