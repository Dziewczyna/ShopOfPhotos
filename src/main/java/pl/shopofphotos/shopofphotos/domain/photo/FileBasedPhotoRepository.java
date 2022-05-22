package pl.shopofphotos.shopofphotos.domain.photo;

import pl.shopofphotos.shopofphotos.domain.UuidRepository;
import pl.shopofphotos.shopofphotos.domain.price.entity.PriceEntity;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.stream.Collectors;

public class FileBasedPhotoRepository implements PhotoRepository {
  private static final String NEW_LINE = System.lineSeparator();
  public final String PHOTOS_FILE_PATH = "shopofphotos\\csvfiles\\Photos.csv";

  @Override
  public void addPhoto(
      PriceEntity price,
      String authorNumber,
      PhotoDetails photoDetails,
      PhotoTechnicalDetails photoTechnicalDetails) {
    UuidRepository uuid = new UuidRepository();
    String photoNumber = uuid.getId();
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
  }

  private StringBuilder formatDataToFile(
      String photoNumber,
      PriceEntity price,
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
  public void editPhoto(
      String photoNumber,
      PriceEntity price,
      String authorNumber,
      PhotoDetails photoDetails,
      PhotoTechnicalDetails photoTechnicalDetails) {
    deletePhoto(photoNumber);
    addPhoto(price, authorNumber, photoDetails, photoTechnicalDetails);
  }

  @Override
  public PriceEntity changePriceOfPhoto(String photoNumber, PriceEntity price) {
    return null;
  }

  private String findPhotoByNumber(String photoNumber) {
    String person = "";
    try {
      person =
          Files.lines(Paths.get(PHOTOS_FILE_PATH)).filter(u -> u.contains(photoNumber)).toString();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return person;
  }

  @Override
  public String readPhoto(String photoNumber) {
    return findPhotoByNumber(photoNumber);
  }

  @Override
  public void deletePhoto(String photoNumber) {
    Path pathToFile = Paths.get(PHOTOS_FILE_PATH);
    try {
      List<String> out =
          Files.lines(pathToFile)
              .filter(line -> !line.contains(photoNumber))
              .collect(Collectors.toList());
      Files.write(pathToFile, out, StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING);
      System.out.println("Photo with id: " + photoNumber + " deleted");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
