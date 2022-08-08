package pl.shopofphotos.shopofphotos.service.price;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import pl.shopofphotos.shopofphotos.domain.price.NoPriceException;
import pl.shopofphotos.shopofphotos.domain.price.PriceJpaRepository;
import pl.shopofphotos.shopofphotos.domain.price.entity.PriceEntity;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
@ActiveProfiles("test")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class PriceServiceTest {
    private static final long PRICE_EXISTING_ID =1L;
    private static final long PRICE_NON_EXISTING_ID =5L;

    @Mock
    private PriceJpaRepository priceJpaRepository;
    private AutoCloseable autoCloseable;
    @Mock
    private PriceEntity priceEntity;
    private PriceService priceService;

    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        priceService = new PriceService(priceJpaRepository);
      }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
      }

   @Test
   public void shouldReturnPrices(){
        //given
        when(priceJpaRepository.findAll()).thenReturn(List.of());

        //when
       var prices = priceService.getPrices();

       //then
       assertEquals(0, prices.size());
   }

    @Test
   public void shouldReturnPrice(){
        //given
        when(priceJpaRepository.findById(PRICE_EXISTING_ID)).thenReturn(Optional.ofNullable(priceEntity));

        //when
        var price = priceService.getPrice(1L);

        //then
        assertNotNull(price);
    }

    @Test
    public void shouldThrowExceptionWhenNoPriceFound() {
        // given
        when(priceJpaRepository.findById(PRICE_NON_EXISTING_ID)).thenReturn(Optional.ofNullable(null));

        // when
        assertThrows(
                NoPriceException.class,
                () -> priceService.getPrice(PRICE_NON_EXISTING_ID),
                "no price with id " + PRICE_NON_EXISTING_ID);
    }
}