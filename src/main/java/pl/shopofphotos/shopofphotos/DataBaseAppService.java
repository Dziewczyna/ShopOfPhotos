package pl.shopofphotos.shopofphotos;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.shopofphotos.shopofphotos.domain.Category;
import pl.shopofphotos.shopofphotos.domain.address.Country;
import pl.shopofphotos.shopofphotos.domain.address.entity.AddressEntity;
import pl.shopofphotos.shopofphotos.domain.camera.entity.CameraEntity;
import pl.shopofphotos.shopofphotos.domain.order.OnlineOrderMethod;
import pl.shopofphotos.shopofphotos.domain.order.entity.OrderEntity;
import pl.shopofphotos.shopofphotos.domain.person.entity.PersonEntity;
import pl.shopofphotos.shopofphotos.domain.photo.entity.PhotoEntity;
import pl.shopofphotos.shopofphotos.domain.price.Currency;
import pl.shopofphotos.shopofphotos.domain.price.entity.PriceEntity;
import pl.shopofphotos.shopofphotos.domain.resolution.Resolution;
import pl.shopofphotos.shopofphotos.service.address.AddressService;
import pl.shopofphotos.shopofphotos.service.camera.CameraService;
import pl.shopofphotos.shopofphotos.service.order.OrderService;
import pl.shopofphotos.shopofphotos.service.person.PersonService;
import pl.shopofphotos.shopofphotos.service.photo.PhotoService;
import pl.shopofphotos.shopofphotos.service.price.PriceService;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class DataBaseAppService implements AppService {
  @Autowired private final PhotoService photoService;
  @Autowired private final AddressService addressService;
  @Autowired private final PersonService personService;
  @Autowired private final PriceService priceService;
  @Autowired private final CameraService cameraService;
  @Autowired private final OrderService orderService;

  @Override
  public void runApp() {
    orderService.deleteAllOrders();
    photoService.deleteAllPhotos();
    priceService.deleteAllPrices();
    cameraService.deleteAllCameras();
    personService.deleteAllPersons();
    addressService.deleteAllAddresses();

    PriceEntity priceEntity = new PriceEntity("123.00", Currency.PLN);
    CameraEntity cameraEntity = new CameraEntity("canon", "e456");
    PhotoEntity photoEntity =
        new PhotoEntity(
            priceEntity,
            "Joasia",
            "details",
            cameraEntity,
            Resolution.RESOLUTION_1051_x_1535,
            "Krakow",
            Category.ANIMALS);

    var photoIdGeneratedByDb = photoService.addPhoto(photoEntity);
    System.out.println(photoService.getPhotos().size());

    PhotoEntity photo = photoService.getPhoto(photoIdGeneratedByDb);
    System.out.println(photo);

    AddressEntity addressEntity =
        new AddressEntity(123, "Piłsudskiego", "Lublin", "lubelskie", "20-705", Country.PL);
    PersonEntity authorEntity = new PersonEntity(1, addressEntity, "Asia", "Szumska");

    AddressEntity addressOfBuyer =
        new AddressEntity(124, "Zamkowa", "Lublin", "lubelskie", "20-706", Country.PL);
    PersonEntity buyerEntity = new PersonEntity(144, addressOfBuyer, "Karol", "Kowalski");

    List<PhotoEntity> photos = new ArrayList<>();
    photos.add(photoEntity);
    OnlineOrderMethod onlineOrderMethod = new OnlineOrderMethod();

    OrderEntity orderEntity =
        new OrderEntity(15, buyerEntity, authorEntity, photos, priceEntity, onlineOrderMethod);
    var orderIdGeneratedByDb = orderService.addOrder(orderEntity);

    System.out.println(photoService.getPhotos().size());
  }
}
