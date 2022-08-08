package pl.shopofphotos.shopofphotos.service.order;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import pl.shopofphotos.shopofphotos.domain.order.NoOrderException;
import pl.shopofphotos.shopofphotos.domain.order.OrderJpaRepository;
import pl.shopofphotos.shopofphotos.domain.order.entity.OrderEntity;
import pl.shopofphotos.shopofphotos.service.order.OrderService;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
@ActiveProfiles("test")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class OrderServiceTest {
    private static final long ORDER_EXISTING_ID=1L;
    private static final long ORDER_NON_EXISTING_ID=5L;

    @Mock
    private OrderJpaRepository orderJpaRepository;
    private AutoCloseable autoCloseable;
    @Mock
    private OrderEntity orderEntity;
    private OrderService orderService;

    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        orderService = new OrderService(orderJpaRepository);
      }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
      }

   @Test
   public void shouldReturnOrders(){
        //given
        when(orderJpaRepository.findAll()).thenReturn(List.of());

        //when
       var orders = orderService.getOrders();

       //then
       assertEquals(0, orders.size());
   }

    @Test
   public void shouldReturnOrder(){
        //given
        when(orderJpaRepository.findById(ORDER_EXISTING_ID)).thenReturn(Optional.ofNullable(orderEntity));

        //when
        var order = orderService.getOrder(1L);

        //then
        assertNotNull(order);
    }

    @Test
    public void shouldThrowExceptionWhenNoOrderFound() {
        // given
        when(orderJpaRepository.findById(ORDER_NON_EXISTING_ID)).thenReturn(Optional.ofNullable(null));

        // when
        assertThrows(
                NoOrderException.class,
                () -> orderService.getOrder(ORDER_NON_EXISTING_ID),
                "no order with id " + ORDER_NON_EXISTING_ID);
    }
}