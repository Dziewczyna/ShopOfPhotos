package pl.shopofphotos.shopofphotos.service.order;

import org.springframework.beans.factory.annotation.Autowired;
import pl.shopofphotos.shopofphotos.domain.order.OrderJpaRepository;
import pl.shopofphotos.shopofphotos.domain.order.entity.OrderEntity;

import java.util.List;
import java.util.Optional;

public class OrderService {
  @Autowired private OrderJpaRepository orderJpaRepository;

  public List<OrderEntity> getOrders() {
    return orderJpaRepository.findAll();
  }

  public OrderEntity getOrder(String orderId) {
    Optional<OrderEntity> orderEntity = orderJpaRepository.findById(Long.valueOf(orderId));
    if (orderEntity.isEmpty()) {
      throw new IllegalArgumentException("No order with id " + orderId);
    }
    return orderEntity.get();
  }

  public long addOrder(OrderEntity orderEntity) {
    return orderJpaRepository.save(orderEntity).getOrderId();
  }

  public void deleteAllOrders() {
    orderJpaRepository.deleteAll();
  }
}
