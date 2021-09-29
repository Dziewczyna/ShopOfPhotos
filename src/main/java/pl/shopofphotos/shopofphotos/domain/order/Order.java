package pl.shopofphotos.shopofphotos.domain.order;

import lombok.AllArgsConstructor;
import pl.shopofphotos.shopofphotos.domain.person.Person;
import pl.shopofphotos.shopofphotos.domain.photo.Photo;
import pl.shopofphotos.shopofphotos.domain.price.Price;

import java.util.List;

@AllArgsConstructor
public class Order {
  public Person buyer;
  public Person author;
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
        + "\nbuyer="
        + buyer
        + ",\nauthor="
        + author
        + ",\nphotos="
        + photos
        + ",\nprice="
        + price
        + '}';
  }
}
