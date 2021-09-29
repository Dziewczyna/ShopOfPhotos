package pl.shopofphotos.shopofphotos.domain.order;

public class PhoneOrderMethod implements OrderMethod {
  @Override
  public void setUpOrderMethod() {
    System.out.println("Order method: by phone");
  }

  private void checkOrderMethod(OrderMethod orderMethod) {
    if (orderMethod == null) {
      throw new NoOrderMethodException("No order method!");
    }
  }
}
