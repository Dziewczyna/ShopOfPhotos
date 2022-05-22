package pl.shopofphotos.shopofphotos;

import org.springframework.stereotype.Service;
import pl.shopofphotos.shopofphotos.domain.Category;
import pl.shopofphotos.shopofphotos.domain.PlaceOfPhoto;
import pl.shopofphotos.shopofphotos.domain.camera.model.CameraModel;
import pl.shopofphotos.shopofphotos.domain.person.Address;
import pl.shopofphotos.shopofphotos.domain.person.Country;
import pl.shopofphotos.shopofphotos.domain.person.FileBasedPersonRepository;
import pl.shopofphotos.shopofphotos.domain.person.PersonRepository;
import pl.shopofphotos.shopofphotos.domain.photo.PhotoDetails;
import pl.shopofphotos.shopofphotos.domain.photo.PhotoTechnicalDetails;
import pl.shopofphotos.shopofphotos.domain.price.Currency;
import pl.shopofphotos.shopofphotos.domain.price.model.PriceModel;
import pl.shopofphotos.shopofphotos.domain.resolution.Resolution;

import java.math.BigDecimal;

@Service
public class FileBasedAppService implements AppService {
  private final PersonRepository fileBasedPersonRepository = new FileBasedPersonRepository();

  @Override
  public void runApp() {
    CameraModel camera = new CameraModel("Sony", "Cyber-shot DSC-RX10 III");
    Resolution resolution = Resolution.resolution1205;
    PlaceOfPhoto placeOfPhoto = new PlaceOfPhoto("Lublin");
    Category category = Category.ANIMALS;
    PriceModel price = new PriceModel(new BigDecimal("123.00"), Currency.PLN);

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
    fileBasedPersonRepository.addPerson("Damian", "Muszka", authorAddress_1);

    PhotoDetails photoDetails = new PhotoDetails(placeOfPhoto, category);
    PhotoTechnicalDetails photoTechnicalDetails = new PhotoTechnicalDetails(camera, resolution);

    //    PhotoModel photo = new PhotoModel(price, authorNumber, photoDetails,
    // photoTechnicalDetails);
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
    Address authorAddress_2 =
        new Address.AddressBuilder()
            .street(authorStreet_2)
            .city(authorCity_2)
            .state(authorState_2)
            .postalCode(authorPostalCode_2)
            .country(authorCountry_2)
            .build();
    fileBasedPersonRepository.editPerson("Damian", "Muszka", authorAddress_2);
  }
}
