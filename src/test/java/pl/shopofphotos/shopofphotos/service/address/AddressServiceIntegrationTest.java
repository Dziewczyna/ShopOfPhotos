package pl.shopofphotos.shopofphotos.service.address;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import pl.shopofphotos.shopofphotos.domain.address.Country;
import pl.shopofphotos.shopofphotos.domain.address.entity.AddressEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ActiveProfiles("test")
@SpringBootTest
@ExtendWith(SpringExtension.class)
public class AddressServiceIntegrationTest {
    @Autowired
    private AddressService addressService;

    @Test
    void shouldReturnAddresses(){
        //given & when
        var addresses = addressService.getAddresses();

        //then
        assertEquals(2, addresses.size());
        assertAddress(addresses.get(0),1,"Zabawna 34/23", "Lublin", "lubelskie", "20-709", Country.PL);
        assertAddress(addresses.get(1),2,"Chabrowa 3/9", "Warszawa", "mazowieckie", "00-791", Country.PL);

    }

    private void assertAddress(AddressEntity addressEntity, int expectedId, String expectedStreet, String expectedCity, String expectedState, String expectedPostalCode, Country expectedCountry){
        assertEquals(expectedId, addressEntity.getAddressId());
        assertEquals(expectedStreet, addressEntity.getStreet());
        assertEquals(expectedCity, addressEntity.getCity());
        assertEquals(expectedState, addressEntity.getState());
        assertEquals(expectedPostalCode, addressEntity.getPostalCode());
        assertEquals(expectedCountry, addressEntity.getCountry());
    }
}
