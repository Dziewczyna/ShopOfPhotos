package pl.shopofphotos.shopofphotos.domain.order.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pl.shopofphotos.shopofphotos.domain.order.OrderMethod;
import pl.shopofphotos.shopofphotos.domain.person.entity.PersonEntity;
import pl.shopofphotos.shopofphotos.domain.photo.entity.PhotoEntity;
import pl.shopofphotos.shopofphotos.domain.price.entity.PriceEntity;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@Entity
@NoArgsConstructor
@Table(name = "orders")
@Getter
public class OrderEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  @SequenceGenerator(name = "hibernate_sequence", allocationSize = 1)
  @Column(name = "order_id")
  public long orderId;

  @OneToOne(
      cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.DETACH},
      fetch = FetchType.EAGER)
  @JoinColumn(name = "buyer_id", referencedColumnName = "person_id")
  public PersonEntity buyerId;

  @OneToOne(
      cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.DETACH},
      fetch = FetchType.EAGER)
  @JoinColumn(name = "author_id", referencedColumnName = "person_id")
  public PersonEntity authorId;

  @ManyToMany(mappedBy = "orders", cascade = CascadeType.PERSIST)
  public List<PhotoEntity> photos;

  @OneToOne(
      cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.DETACH},
      fetch = FetchType.EAGER)
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
