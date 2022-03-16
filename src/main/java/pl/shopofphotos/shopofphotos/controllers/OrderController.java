package pl.shopofphotos.shopofphotos.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pl.shopofphotos.shopofphotos.domain.order.NoOrderMethodException;
import pl.shopofphotos.shopofphotos.domain.order.Order;
import pl.shopofphotos.shopofphotos.service.order.OrderService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@Slf4j
public class OrderController {

  @Autowired private OrderService orderService;

  @GetMapping("/orders")
  public List<Order> getOrder() {
    log.info("fetching all orders");
    return orderService.getOrders();
  }

  @GetMapping("/orders/{orderId}")
  public Order getOrderBy(@PathVariable String orderId) {
    log.info("fetching order with id " + orderId);
    return orderService.getOrder(orderId);
  }

  @ExceptionHandler(NoOrderMethodException.class)
  public ResponseEntity<String> handleBadIdInRequest(
      IllegalArgumentException exception, HttpServletRequest httpServletRequest) {
    log.warn("bad order id was provided");
    return new ResponseEntity<>("Provided id is not valid", HttpStatus.NOT_FOUND);
  }
}
