package pl.shopofphotos.shopofphotos.service.photo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import pl.shopofphotos.shopofphotos.domain.photo.PhotoJpaRepository;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@ActiveProfiles("test")
class PhotoServiceTest {
  private static final long PHOTO_EXISTING_ID = 1L;
  private static final long PHOTO_NON_EXISTING_ID = 5L;

  @Mock private PhotoJpaRepository photoJpaRepository;
  @Autowired private PhotoService photoService;

  @Test
  void shouldReturnPhotos() {
    // given & when
    var photos = photoService.getPhotos();
    System.out.println("--- " + photos.toString());
    // then
    assertEquals(2, photos.size());
  }

  @Test
  public void shouldReturnPhoto() {
    // given & when
    var photo = photoService.getPhoto(1L);

    // then
    assertNotNull(photo);
  }

  @Test
  public void shouldThrowExceptionWhenNoPhotoFound() {
    // given & when
    assertThrows(
        IllegalArgumentException.class,
        () -> photoService.getPhoto(PHOTO_NON_EXISTING_ID),
        "no photo with id " + PHOTO_NON_EXISTING_ID);
  }
}
