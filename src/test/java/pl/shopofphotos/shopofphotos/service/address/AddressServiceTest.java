package pl.shopofphotos.shopofphotos.service.address;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import pl.shopofphotos.shopofphotos.domain.address.AddressJpaRepository;
import pl.shopofphotos.shopofphotos.domain.address.NoAddressException;
import pl.shopofphotos.shopofphotos.domain.address.entity.AddressEntity;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
@ActiveProfiles("test")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class AddressServiceTest {
    private static final long ADDRESS_EXISTING_ID =1L;
    private static final long ADDRESS_NON_EXISTING_ID =5L;

    @Mock
    private AddressJpaRepository addressJpaRepository;
    private AutoCloseable autoCloseable;
    @Mock
    private AddressEntity addressEntity;
    private AddressService addressService;

    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        addressService = new AddressService(addressJpaRepository);
      }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
      }

   @Test
   public void shouldReturnAddresss(){
        //given
        when(addressJpaRepository.findAll()).thenReturn(List.of());

        //when
       var addresses = addressService.getAddresses();

       //then
       assertEquals(0, addresses.size());
   }

    @Test
   public void shouldReturnAddress() throws NoAddressException {
        //given
        when(addressJpaRepository.findById(ADDRESS_EXISTING_ID)).thenReturn(Optional.ofNullable(addressEntity));

        //when
        var address = addressService.getAddress(1L);

        //then
        assertNotNull(address);
    }

    @Test
    public void shouldThrowExceptionWhenNoAddressFound() {
        // given
        when(addressJpaRepository.findById(ADDRESS_NON_EXISTING_ID)).thenReturn(Optional.ofNullable(null));

        // when
        assertThrows(
                NoAddressException.class,
                () -> addressService.getAddress(ADDRESS_NON_EXISTING_ID),
                "no address with id " + ADDRESS_NON_EXISTING_ID);
    }
}