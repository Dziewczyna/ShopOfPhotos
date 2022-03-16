package pl.shopofphotos.shopofphotos.service.order;

import org.springframework.stereotype.Service;
import pl.shopofphotos.shopofphotos.domain.order.Order;
import pl.shopofphotos.shopofphotos.domain.order.OrderJpaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
  private OrderJpaRepository orderJpaRepository;

  public List<Order> getOrders() {
    return orderJpaRepository.findAll();
  }

  public Order getOrder(String orderId) {
    Optional<Order> order = orderJpaRepository.findById(orderId);
    if (order.isEmpty()) {
      throw new IllegalArgumentException("No order with id " + orderId);
    }
    return order.get();
  }
}
