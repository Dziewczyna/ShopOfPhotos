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
import java.util.stream.Collectors;

public class FileBasedOrderRepository implements OrderRepository {
  private static final String NEW_LINE = System.lineSeparator();
  public final String ORDERS_FILE_PATH = "shopofphotos\\csvfiles\\Orders.csv";
  private final List<Order> orders = new ArrayList<>();

  @Override
  public void placeOrder(
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

      System.out.println("Order with orderId=" + order.orderId + " added to the file");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private StringBuilder formatDataToFile(
      String buyerNumber,
      String authorNumber,
      List<Photo> photos,
      Price price,
      OrderMethod orderMethod) {
    return new StringBuilder()
        .append(buyerNumber)
        .append("; ")
        .append(authorNumber)
        .append("; ")
        .append(photos)
        .append("; ")
        .append(price)
        .append("; ")
        .append(orderMethod)
        .append(NEW_LINE);
  }

  @Override
  public Photo editPhoto(Photo photo) {
    String order = findOrderBy(photo.getPhotoTechnicalDetails().toString());
    String orderNumber = findOrderNumberFromLine(order);
    return null;
  }

  @Override
  public Price changePrice(String orderNumber, Price price) {
    String order = findOrderBy(orderNumber);
    deleteOrder(orderNumber);

    return null;
  }

  private String findOrderBy(String findBy) {
    String order = "";
    try {
      order = Files.lines(Paths.get(ORDERS_FILE_PATH)).filter(u -> u.contains(findBy)).toString();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return order;
  }

  private String findOrderNumberFromLine(String orderLineFromFile) {
    String order = "";
    try {
      order =
          Files.lines(Paths.get(ORDERS_FILE_PATH))
              .filter(u -> u.contains(orderLineFromFile))
              .toString();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return order;
  }

  @Override
  public String readOrder(String orderNumber) {
    return findOrderBy(orderNumber);
  }

  @Override
  public void deleteOrder(String orderNumber) {
    Path pathToFile = Paths.get(ORDERS_FILE_PATH);
    try {
      List<String> out =
          Files.lines(pathToFile)
              .filter(line -> !line.contains(orderNumber))
              .collect(Collectors.toList());
      Files.write(pathToFile, out, StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING);
      System.out.println("Order with number" + orderNumber + " deleted");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
