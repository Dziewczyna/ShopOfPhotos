package pl.shopofphotos.shopofphotos.service.order;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.shopofphotos.shopofphotos.domain.order.NoOrderException;
import pl.shopofphotos.shopofphotos.domain.order.OrderJpaRepository;
import pl.shopofphotos.shopofphotos.domain.order.entity.OrderEntity;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class OrderService {
  @Autowired private OrderJpaRepository orderJpaRepository;

  public List<OrderEntity> getOrders() {
    return orderJpaRepository.findAll();
  }

  public OrderEntity getOrder(long orderId) {
    Optional<OrderEntity> orderEntity = orderJpaRepository.findById(orderId);
    if (orderEntity.isEmpty()) {
      throw new NoOrderException("No order with id " + orderId);
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
