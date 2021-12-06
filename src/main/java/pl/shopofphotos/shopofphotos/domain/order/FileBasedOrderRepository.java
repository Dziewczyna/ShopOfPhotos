package pl.shopofphotos.shopofphotos.domain.order;

import pl.shopofphotos.shopofphotos.domain.UuidRepository;
import pl.shopofphotos.shopofphotos.domain.photo.Photo;
import pl.shopofphotos.shopofphotos.domain.price.Price;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class FileBasedOrderRepository implements OrderRepository {
  private static final String NEW_LINE = System.lineSeparator();
  public final String ORDERS_FILE_PATH = "shopofphotos\\csvfiles\\Orders.csv";
  private final List<Order> orders = new ArrayList<>();

  @Override
  public String placeOrder(
      String buyerNumber,
      String authorNumber,
      List<Photo> photos,
      Price price,
      OrderMethod orderMethod) {
    UuidRepository uuid = new UuidRepository();
    String orderNumber = uuid.getId();

    Order order = new Order(orderNumber, buyerNumber, authorNumber, photos, price, orderMethod);
    try {
      Path path = Paths.get(ORDERS_FILE_PATH);
      Files.writeString(
          path,
          formatDataToFile(buyerNumber, authorNumber, photos, price, orderMethod),
          StandardOpenOption.CREATE,
          StandardOpenOption.APPEND);

      System.out.println("Order with orderId=" + order.orderNumber + " added to the file");
    } catch (IOException e) {
      e.printStackTrace();
    }
    return orderNumber;
  }

  private StringBuilder formatDataToFile(
      String buyerNumber,
      String authorNumber,
      List<Photo> photos,
      Price price,
      OrderMethod orderMethod) {
    return new StringBuilder()
        .append(buyerNumber)
        .append(authorNumber)
        .append(photos)
        .append(price)
        .append(orderMethod)
        .append(NEW_LINE);
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
  public Order readOrder(String orderId) {
    //    System.out.println(orders.get(orderId).toString());
    //    return orders.get(orderId);
    return null;
  }

  @Override
  public void deleteOrder(String orderId) {
    //    orders.remove(orderId);
    //    System.out.println("Order with orderId=" + orderId + " removed");
  }
}
