package pl.shopofphotos.shopofphotos.domain.order;

public class PersonallyOrderMethod implements OrderMethod {
  @Override
  public void setUpOrderMethod() {
    System.out.println("Order method: personally");
  }

  private void checkOrderMethod(OrderMethod orderMethod) {
    if (orderMethod == null) {
      throw new NoOrderMethodException("No order method!");
    }
  }
}
