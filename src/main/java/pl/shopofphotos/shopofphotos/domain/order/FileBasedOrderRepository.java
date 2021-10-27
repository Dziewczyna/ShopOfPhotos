package pl.shopofphotos.shopofphotos.domain.order;

import pl.shopofphotos.shopofphotos.domain.person.Person;
import pl.shopofphotos.shopofphotos.domain.photo.Photo;
import pl.shopofphotos.shopofphotos.domain.price.Price;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class FileBasedOrderRepository implements OrderRepository {
  public final String ORDERS_FILE_PATH = "shopofphotos\\src\\main\\resources\\Orders.csv";
  private final List<Order> orders = new ArrayList<>();

  @Override
  public String placeOrder(
      Person buyer, Person author, List<Photo> photos, Price price, OrderMethod orderMethod) {
    String orderNumber = UUID.randomUUID().toString();
    Order order = new Order(orderNumber, buyer, author, photos, price, orderMethod);
    try {
      BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(ORDERS_FILE_PATH, true));
      bufferedWriter.write(formatDataToFile(buyer, author, photos, price, orderMethod));
      System.out.println("Order with orderId=" + order.orderNumber + " added to the file");
      bufferedWriter.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return order.orderNumber;
  }

  private String formatDataToFile(
      Person buyer, Person author, List<Photo> photos, Price price, OrderMethod orderMethod) {
    return "\n"
        + buyer.toString()
        + ";"
        + author.toString()
        + ";"
        + photos.toString()
        + ";"
        + price.toString()
        + ";"
        + orderMethod.toString();
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
