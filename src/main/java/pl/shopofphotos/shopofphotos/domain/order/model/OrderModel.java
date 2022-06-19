package pl.shopofphotos.shopofphotos.domain.order.model;

import lombok.Builder;
import pl.shopofphotos.shopofphotos.domain.person.model.PersonModel;
import pl.shopofphotos.shopofphotos.domain.price.model.PriceModel;

@Builder
public class OrderModel {
  private final PersonModel buyer;
  private final PersonModel author;
  private final PriceModel price;

  public OrderModel(PersonModel buyer, PersonModel author, PriceModel price) {
    this.buyer = buyer;
    this.author = author;
    this.price = price;
  }

  public PersonModel getBuyer() {
    return buyer;
  }

  public PersonModel getAuthor() {
    return author;
  }

  public PriceModel getPrice() {
    return price;
  }

  @Override
  public String toString() {
    return "OrderModel{" + "buyer=" + buyer + ", author=" + author + ", price=" + price + '}';
  }
}
