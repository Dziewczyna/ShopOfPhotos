package pl.shopofphotos.shopofphotos.domain.order;

import pl.shopofphotos.shopofphotos.domain.person.Person;
import pl.shopofphotos.shopofphotos.domain.photo.Photo;
import pl.shopofphotos.shopofphotos.domain.price.Price;

import java.util.List;

public interface OrderRepository {
  int placeOrder(
      Person buyer, Person author, List<Photo> photos, Price price, OrderMethod orderMethod);

  Photo editPhoto(Photo photo);

  Price changePrice(Price price);

  Order readOrder(int orderId);

  void deleteOrder(int orderId);
}
