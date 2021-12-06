package pl.shopofphotos.shopofphotos.domain.photo;

import pl.shopofphotos.shopofphotos.domain.UuidRepository;
import pl.shopofphotos.shopofphotos.domain.order.Order;
import pl.shopofphotos.shopofphotos.domain.price.Price;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

import static java.lang.String.format;

public class FileBasedPhotoRepository implements PhotoRepository {
  private static final String NEW_LINE = System.lineSeparator();
  public final String PHOTOS_FILE_PATH = "shopofphotos\\csvfiles\\Photos.csv";
  private final List<Order> photos = new ArrayList<>();

  @Override
  public String addPhoto(
      Price price,
      String authorNumber,
      PhotoDetails photoDetails,
      PhotoTechnicalDetails photoTechnicalDetails) {
    UuidRepository uuid = new UuidRepository();
    String photoNumber = uuid.getId();
    Photo photo = new Photo(price, authorNumber, photoDetails, photoTechnicalDetails);
    try {
      Path pathToFile = Paths.get(PHOTOS_FILE_PATH);
      Files.writeString(
          pathToFile,
          formatDataToFile(photoNumber, price, authorNumber, photoDetails, photoTechnicalDetails),
          StandardOpenOption.CREATE,
          StandardOpenOption.APPEND);
      System.out.printf("Photo with number %s added to the file%n", photoNumber);
    } catch (IOException e) {
      e.printStackTrace();
    }
    return photoNumber;
  }

  private StringBuilder formatDataToFile(
      String photoNumber,
      Price price,
      String authorNumber,
      PhotoDetails photoDetails,
      PhotoTechnicalDetails photoTechnicalDetails) {
    return new StringBuilder()
        .append(photoNumber)
        .append(price)
        .append(authorNumber)
        .append(photoDetails)
        .append(photoTechnicalDetails)
        .append(NEW_LINE);
  }

  @Override
  public Photo editPhoto(Photo photo) {
    return null;
  }

  @Override
  public Price changePhoto(Price price) {
    return null;
  }

  @Override
  public Order readPhoto(int photoId) {
    return null;
  }

  @Override
  public void deletePhoto(int photoId) {}
}
