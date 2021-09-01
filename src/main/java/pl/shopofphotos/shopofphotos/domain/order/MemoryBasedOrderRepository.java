package pl.shopofphotos.shopofphotos.domain.order;

import pl.shopofphotos.shopofphotos.domain.person.Person;
import pl.shopofphotos.shopofphotos.domain.photo.Photo;
import pl.shopofphotos.shopofphotos.domain.price.Price;

import java.util.ArrayList;
import java.util.List;

public class MemoryBasedOrderRepository implements OrderRepository {
  private final List<Order> orders = new ArrayList<>();

  @Override
  public int placeOrder(Person buyer, Person author, List<Photo> photos, Price price) {
    Order order = new Order(buyer, author, photos, price);
    orders.add(order);
    System.out.println("Order with orderId=" + orders.indexOf(order) + " added");
    return orders.indexOf(order);
  }

  @Override
  public Photo editPhoto(Photo photo) {
    return null;
  }

  @Override
  public Price changePrice(Price price) {
    return null;
  }

  @Override
  public Order readOrder(int orderId) {
    System.out.println(orders.get(orderId).toString());
    return orders.get(orderId);
  }

  @Override
  public void deleteOrder(int orderId) {
    orders.remove(orderId);
    System.out.println("Order with orderId=" + orderId + " removed");
  }
}
