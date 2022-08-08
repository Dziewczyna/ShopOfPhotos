package pl.shopofphotos.shopofphotos.service.price;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import pl.shopofphotos.shopofphotos.domain.price.Currency;
import pl.shopofphotos.shopofphotos.domain.price.entity.PriceEntity;
import pl.shopofphotos.shopofphotos.service.price.PriceService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ActiveProfiles("test")
@SpringBootTest
@ExtendWith(SpringExtension.class)
public class PriceServiceIntegrationTest {
    @Autowired
    private PriceService priceService;

    @Test
    void shouldReturnPrices(){
        //given & when
        var prices = priceService.getPrices();

        //then
        assertEquals(2, prices.size());
        assertPrice(prices.get(0),1,"3799", Currency.PLN);
        assertPrice(prices.get(1),2,"2699", Currency.PLN);

    }

    private void assertPrice(PriceEntity priceEntity, int expectedId, String expectedPrice, Currency expectedCurrency){
        assertEquals(expectedId, priceEntity.getPriceId());
        assertEquals(expectedPrice, priceEntity.getPrice());
        assertEquals(expectedCurrency, priceEntity.getCurrency());
    }
}
