package pl.shopofphotos.shopofphotos.service.order;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import pl.shopofphotos.shopofphotos.domain.order.entity.OrderEntity;
import pl.shopofphotos.shopofphotos.service.order.OrderService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ActiveProfiles("test")
@SpringBootTest
@ExtendWith(SpringExtension.class)
public class OrderServiceIntegrationTest {
    @Autowired
    private OrderService orderService;

    @Test
    void shouldReturnOrders(){
        //given & when
        var orders = orderService.getOrders();

        //then
        assertEquals(2, orders.size());
        assertOrder(orders.get(0),1,"1","1","1","1","ONLINE");
        assertOrder(orders.get(1),2,"2","2","2","2","ONLINE");

    }

    private void assertOrder(OrderEntity orderEntity, int expectedId, String expectedBuyerId, String expectedAuthorId, String expectedPhotoId, String expectedPriceId, String expectedOrderMethod){
        assertEquals(expectedId, orderEntity.getOrderId());
        assertNotNull(orderEntity.getBuyerId());
        assertNotNull(orderEntity.getAuthorId());
        assertNotNull(orderEntity.getPhotos());
        assertNotNull(orderEntity.getPrice());
    }
}
