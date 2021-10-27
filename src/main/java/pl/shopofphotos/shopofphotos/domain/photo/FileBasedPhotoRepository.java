package pl.shopofphotos.shopofphotos.domain.photo;

import pl.shopofphotos.shopofphotos.domain.order.Order;
import pl.shopofphotos.shopofphotos.domain.person.Person;
import pl.shopofphotos.shopofphotos.domain.price.Price;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileBasedPhotoRepository implements PhotoRepository {
  public final String PHOTOS_FILE_PATH = "shopofphotos\\src\\main\\resources\\Photos.csv";
  private final List<Order> photos = new ArrayList<>();

  @Override
  public boolean addPhoto(
      Price price,
      Person author,
      PhotoDetails photoDetails,
      PhotoTechnicalDetails photoTechnicalDetails) {
    Photo photo = new Photo(price, author, photoDetails, photoTechnicalDetails);
    try {
      BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(PHOTOS_FILE_PATH, true));
      bufferedWriter.write(formatDataToFile(price, author, photoDetails, photoTechnicalDetails));
      System.out.println("Photo added to the file");
      bufferedWriter.close();
      return true;
    } catch (IOException e) {
      e.printStackTrace();
      return false;
    }
  }

  private String formatDataToFile(
      Price price,
      Person author,
      PhotoDetails photoDetails,
      PhotoTechnicalDetails photoTechnicalDetails) {
    return "\n"
        + price.toString()
        + ";"
        + author.toString()
        + ";"
        + photoDetails.toString()
        + ";"
        + photoTechnicalDetails.toString();
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
