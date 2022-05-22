package pl.shopofphotos.shopofphotos.domain.order.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import pl.shopofphotos.shopofphotos.domain.order.OrderMethod;
import pl.shopofphotos.shopofphotos.domain.person.Person;
import pl.shopofphotos.shopofphotos.domain.photo.entity.PhotoEntity;
import pl.shopofphotos.shopofphotos.domain.price.entity.PriceEntity;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@Entity
@NoArgsConstructor
@Table(name = "order")
public class OrderEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "order_id")
  public String orderId;

  @OneToOne(cascade = CascadeType.PERSIST)
  @JoinColumn(name = "buyer_id", referencedColumnName = "person_id")
  public Person buyerId;

  @OneToOne(cascade = CascadeType.PERSIST)
  @JoinColumn(name = "author_id", referencedColumnName = "person_id")
  public Person authorId;

  @ManyToMany(cascade = CascadeType.PERSIST)
  @JoinColumn(name = "photo_id", referencedColumnName = "photo_id")
  public List<PhotoEntity> photos;

  @OneToOne(cascade = CascadeType.PERSIST)
  @JoinColumn(name = "price_id", referencedColumnName = "price_id")
  public PriceEntity price;

  @Transient private OrderMethod orderMethod;

  public void chooseOrderMethod() {
    System.out.println("Choose order method");
    orderMethod.setUpOrderMethod();
  }

  @Override
  public String toString() {
    return "Order{"
        + "\norderNumber="
        + orderId
        + "\nbuyer="
        + buyerId
        + ",\nauthor="
        + authorId
        + ",\nphotos="
        + photos
        + ",\nprice="
        + price
        + '}';
  }
}
