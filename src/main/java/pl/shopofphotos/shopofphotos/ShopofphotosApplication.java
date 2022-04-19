package pl.shopofphotos.shopofphotos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.shopofphotos.shopofphotos.domain.Category;
import pl.shopofphotos.shopofphotos.domain.PlaceOfPhoto;
import pl.shopofphotos.shopofphotos.domain.order.FileBasedOrderRepository;
import pl.shopofphotos.shopofphotos.domain.order.OnlineOrderMethod;
import pl.shopofphotos.shopofphotos.domain.order.OrderMethod;
import pl.shopofphotos.shopofphotos.domain.order.OrderRepository;
import pl.shopofphotos.shopofphotos.domain.person.Address;
import pl.shopofphotos.shopofphotos.domain.person.Country;
import pl.shopofphotos.shopofphotos.domain.person.FileBasedPersonRepository;
import pl.shopofphotos.shopofphotos.domain.person.PersonRepository;
import pl.shopofphotos.shopofphotos.domain.photo.FileBasedPhotoRepository;
import pl.shopofphotos.shopofphotos.domain.photo.entities.PhotoEntity;
import pl.shopofphotos.shopofphotos.domain.photo.PhotoDetails;
import pl.shopofphotos.shopofphotos.domain.photo.PhotoRepository;
import pl.shopofphotos.shopofphotos.domain.resolution.Resolution;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class ShopofphotosApplication {

  public static void main(String[] args) {
    //        Camera camera = new Camera("Sony", "Cyber-shot DSC-RX10 III");
    Resolution resolution = Resolution.resolution1205;
    PlaceOfPhoto placeOfPhoto = new PlaceOfPhoto("Lublin");
    Category category = Category.ANIMALS;
    //    Price price = new Price(new BigDecimal("123.00"), Currency.PLN);

    String authorStreet = "Polna";
    String authorCity = "Lublin";
    String authorState = "lubelskie";
    String authorPostalCode = "20-714";
    Country authorCountry = Country.PL;
    Address authorAddress_1 =
        new Address.AddressBuilder()
            .street(authorStreet)
            .city(authorCity)
            .state(authorState)
            .postalCode(authorPostalCode)
            .country(authorCountry)
            .build();
    PersonRepository fileBasedPersonRepository = new FileBasedPersonRepository();
    fileBasedPersonRepository.addPerson("Damian", "Muszka", authorAddress_1);

    PhotoDetails photoDetails = new PhotoDetails(placeOfPhoto, category);
    //    PhotoTechnicalDetails photoTechnicalDetails = new PhotoTechnicalDetails(camera,
    // resolution);

    //    Photo photo = new Photo(price, authorNumber, photoDetails, photoTechnicalDetails);
    //    photo = new PhotoFramed(new Frame(), photo);

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
    fileBasedPersonRepository.addPerson("Jolanta", "Panek", buyerAddress);

    fileBasedPersonRepository.readPersons();
    String personNumber = fileBasedPersonRepository.getPersonNumber(0);
    fileBasedPersonRepository.deletePerson("Jolanta", "Panek");

    String authorStreet_2 = "Al. Warszawskie";
    String authorCity_2 = "Kostrzyn";
    String authorState_2 = "wielkopolskie";
    String authorPostalCode_2 = "62-025";
    Country authorCountry_2 = Country.PL;
    //    Address authorAddress_2 =
    //        new Address(
    //            authorStreet_2, authorCity_2, authorState_2, authorPostalCode_2, authorCountry_2);
    //    fileBasedPersonRepository.editPerson("Damian", "Muszka", authorAddress_2);

    List<PhotoEntity> photos = new ArrayList<>();
    //    photos.add(photo);
    //    Price priceOfOrder = new Price(new BigDecimal("123.00"), Currency.PLN);
    OrderMethod orderMethod = new OnlineOrderMethod();

    PhotoRepository fileBasedPhotoRepository = new FileBasedPhotoRepository();
    //        fileBasedPhotoRepository.addPhoto(price, personNumber, photoDetails,
    //     photoTechnicalDetails);

    OrderRepository fileBasedOrderRepository = new FileBasedOrderRepository();
    //    String placedOrderId =
    //        fileBasedOrderRepository.placeOrder(
    //            buyerNumber, authorNumber, photos, priceOfOrder, orderMethod);

    //    fileBasedOrderRepository.readOrder(placedOrderId);
    //
    //    fileBasedOrderRepository.deleteOrder(placedOrderId);

    SpringApplication.run(ShopofphotosApplication.class, args);
  }
}
