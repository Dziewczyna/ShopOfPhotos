package pl.shopofphotos.shopofphotos.domain.order;

// @AllArgsConstructor
// @Entity
// @NoArgsConstructor
// @Table(name = "order")
public class Order {
  //  @Id
  //  @GeneratedValue(strategy = GenerationType.AUTO)
  //  @Column(name = "order_id")
  //  public String orderId;
  //
  //  @OneToOne(cascade = CascadeType.MERGE)
  //  @JoinColumn(name = "buyer_id", referencedColumnName = "person_id")
  //  public Person buyerId;
  //
  //  @OneToOne(cascade = CascadeType.MERGE)
  //  @JoinColumn(name = "author_id", referencedColumnName = "person_id")
  //  public Person authorId;
  //
  //  @ManyToMany(cascade = CascadeType.MERGE)
  //  @JoinColumn(name = "photo_id", referencedColumnName = "photo_id")
  //  public List<PhotoEntity> photos;
  //
  //  @OneToOne(cascade = CascadeType.MERGE)
  //  @JoinColumn(name = "price_id", referencedColumnName = "price_id")
  //  public Price price;
  //
  //  @Transient
  //  private OrderMethod orderMethod;
  //
  //  public void chooseOrderMethod() {
  //    System.out.println("Choose order method");
  //    orderMethod.setUpOrderMethod();
  //  }
  //
  //  @Override
  //  public String toString() {
  //    return "Order{"
  //        + "\norderNumber="
  //        + orderId
  //        + "\nbuyer="
  //        + buyerId
  //        + ",\nauthor="
  //        + authorId
  //        + ",\nphotos="
  //        + photos
  //        + ",\nprice="
  //        + price
  //        + '}';
  //  }
}
