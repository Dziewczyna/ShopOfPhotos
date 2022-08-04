package pl.shopofphotos.shopofphotos.service.photo;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import pl.shopofphotos.shopofphotos.domain.photo.NoPhotoException;
import pl.shopofphotos.shopofphotos.domain.photo.PhotoJpaRepository;
import pl.shopofphotos.shopofphotos.domain.photo.entity.PhotoEntity;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@ActiveProfiles("test")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class PhotoServiceTest {
  private static final long PHOTO_EXISTING_ID = 1L;
  private static final long PHOTO_NON_EXISTING_ID = 5L;

  @Mock private PhotoJpaRepository photoJpaRepository;
  private AutoCloseable autoCloseable;
  @Mock private PhotoEntity photoEntity;
  private PhotoService photoService;

  @BeforeEach
  public void setUp() {
    autoCloseable = MockitoAnnotations.openMocks(this);
    photoService = new PhotoService(photoJpaRepository);
  }

  @AfterEach
  public void tearDown() throws Exception {
    autoCloseable.close();
  }

  // this test mocks repository
  @Test
  public void shouldReturnPhoto() {
    // given
    when(photoJpaRepository.findById(PHOTO_EXISTING_ID)).thenReturn(Optional.of(photoEntity));
    // when
    var photo = photoService.getPhoto(1L);

    // then
    assertNotNull(photo);
  }

  // this test mocks repository
  @Test
  void shouldReturnPhotos() {
    // given
    when(photoJpaRepository.findAll()).thenReturn(List.of());

    // when
    var photos = photoService.getPhotos();
    // then
    assertEquals(0, photos.size());
  }

  // this test mocks repository
  @Test
  public void shouldThrowExceptionWhenNoPhotoFound() {
    // given
    when(photoJpaRepository.findById(PHOTO_NON_EXISTING_ID)).thenReturn(Optional.ofNullable(null));

    // when
    assertThrows(
        NoPhotoException.class,
        () -> photoService.getPhoto(PHOTO_NON_EXISTING_ID),
        "no photo with id " + PHOTO_NON_EXISTING_ID);
  }
}
