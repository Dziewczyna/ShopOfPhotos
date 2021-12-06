package pl.shopofphotos.shopofphotos.domain.order;

import lombok.AllArgsConstructor;
import pl.shopofphotos.shopofphotos.domain.photo.Photo;
import pl.shopofphotos.shopofphotos.domain.price.Price;

import java.util.List;

@AllArgsConstructor
public class Order {
  public String orderNumber;
  public String buyerNumber;
  public String authorNumber;
  public List<Photo> photos;
  public Price price;
  private OrderMethod orderMethod;

  public void chooseOrderMethod() {
    System.out.println("Choose order method");
    orderMethod.setUpOrderMethod();
  }

  @Override
  public String toString() {
    return "Order{"
        + "\norderNumber="
        + orderNumber
        + "\nbuyer="
        + buyerNumber
        + ",\nauthor="
        + authorNumber
        + ",\nphotos="
        + photos
        + ",\nprice="
        + price
        + '}';
  }
}
