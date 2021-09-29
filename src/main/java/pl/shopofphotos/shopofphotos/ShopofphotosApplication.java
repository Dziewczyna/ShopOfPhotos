package pl.shopofphotos.shopofphotos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.shopofphotos.shopofphotos.domain.Category;
import pl.shopofphotos.shopofphotos.domain.PlaceOfPhoto;
import pl.shopofphotos.shopofphotos.domain.camera.Camera;
import pl.shopofphotos.shopofphotos.domain.order.MemoryBasedOrderRepository;
import pl.shopofphotos.shopofphotos.domain.order.OnlineOrderMethod;
import pl.shopofphotos.shopofphotos.domain.order.OrderRepository;
import pl.shopofphotos.shopofphotos.domain.person.Address;
import pl.shopofphotos.shopofphotos.domain.person.Country;
import pl.shopofphotos.shopofphotos.domain.person.Person;
import pl.shopofphotos.shopofphotos.domain.photo.Photo;
import pl.shopofphotos.shopofphotos.domain.price.Currency;
import pl.shopofphotos.shopofphotos.domain.price.Price;
import pl.shopofphotos.shopofphotos.domain.resolution.Resolution;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class ShopofphotosApplication {

  public static void main(String[] args) {
    Camera camera = new Camera("Sony", "Cyber-shot DSC-RX10 III");
    Resolution resolution = Resolution.resolution1205;
    PlaceOfPhoto placeOfPhoto = new PlaceOfPhoto("Lublin");
    Category category = Category.ANIMALS;
    Price price = new Price(new BigDecimal("123.00"), Currency.PLN);

    String authorStreet = "Polna";
    String authorCity = "Lublin";
    String authorState = "lubelskie";
    String authorPostalCode = "20-714";
    Country authorCountry = Country.PL;
    Address authorAddress =
        new Address.AddressBuilder()
            .street(authorStreet)
            .city(authorCity)
            .state(authorState)
            .postalCode(authorPostalCode)
            .country(authorCountry)
            .build();
    Person author = new Person("Damian", "Muszka", authorAddress);
    Photo photo =
        new Photo.PhotoBuilder()
            .camera(camera)
            .resolution(resolution)
            .placeOfPhoto(placeOfPhoto)
            .category(category)
            .price(price)
            .author(author)
            .build();

    String buyerStreet = "Rolna";
    String buyerCity = "Warszawa";
    String buyerState = "mazowieckie";
    String buyerPostalCode = "00-001";
    Country buyerCountry = Country.PL;
    Address buyerAddress =
        new Address.AddressBuilder()
            .street(buyerStreet)
            .city(buyerCity)
            .state(buyerState)
            .postalCode(buyerPostalCode)
            .country(buyerCountry)
            .build();
    Person buyer = new Person("Jolanta", "Patka", buyerAddress);

    List<Photo> photos = new ArrayList<>();
    photos.add(photo);
    Price priceOfOrder = new Price(new BigDecimal("123.00"), Currency.PLN);
    OnlineOrderMethod orderMethod = new OnlineOrderMethod();

    OrderRepository memoryBasedOrderRepository = new MemoryBasedOrderRepository();
    int placedOrderId =
        memoryBasedOrderRepository.placeOrder(buyer, author, photos, priceOfOrder, orderMethod);
    memoryBasedOrderRepository.readOrder(placedOrderId);

    memoryBasedOrderRepository.deleteOrder(placedOrderId);

    SpringApplication.run(ShopofphotosApplication.class, args);
  }
}
