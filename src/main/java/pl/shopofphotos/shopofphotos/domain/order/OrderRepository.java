package pl.shopofphotos.shopofphotos.domain.order;

import pl.shopofphotos.shopofphotos.domain.photo.Photo;
import pl.shopofphotos.shopofphotos.domain.price.Price;

import java.util.List;

public interface OrderRepository {
  void placeOrder(
      String buyerNumber,
      String authorNumber,
      List<Photo> photos,
      Price price,
      OrderMethod orderMethod);

  Photo editPhoto(Photo photo);

  Price changePrice(String orderNumber, Price price);

  String readOrder(String orderNumber);

  void deleteOrder(String orderNumber);
}
