package pl.shopofphotos.shopofphotos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.shopofphotos.shopofphotos.domain.Category;
import pl.shopofphotos.shopofphotos.domain.PlaceOfPhoto;
import pl.shopofphotos.shopofphotos.domain.camera.Camera;
import pl.shopofphotos.shopofphotos.domain.dimension.Dimension;
import pl.shopofphotos.shopofphotos.domain.order.MemoryBasedOrderRepository;
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
    Person author =
        new Person(
            "Damian", "Muszka", new Address("Polna", "Lublin", "lubelskie", "20-714", Country.PL));
    Photo photo =
        new Photo.PhotoBuilder()
            .camera(camera)
            .resolution(resolution)
            .dimension(Dimension.dimension1318)
            .placeOfPhoto(placeOfPhoto)
            .category(category)
            .price(price)
            .author(author)
            .build();

    Person buyer =
        new Person(
            "Jolanta",
            "Patka",
            new Address("Rolna", "Warszawa", "mazowieckie", "00-001", Country.PL));

    List<Photo> photos = new ArrayList<>();
    photos.add(photo);
    Price priceOfOrder = new Price(new BigDecimal("123.00"), Currency.PLN);

    MemoryBasedOrderRepository memoryBasedOrderRepository = new MemoryBasedOrderRepository();
    int placedOrderId = memoryBasedOrderRepository.placeOrder(buyer, author, photos, priceOfOrder);
    memoryBasedOrderRepository.readOrder(placedOrderId);

    memoryBasedOrderRepository.deleteOrder(placedOrderId);

    SpringApplication.run(ShopofphotosApplication.class, args);
  }
}
