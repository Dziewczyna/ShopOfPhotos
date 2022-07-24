package pl.shopofphotos.shopofphotos.service.photo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import pl.shopofphotos.shopofphotos.domain.photo.NoPhotoException;
import pl.shopofphotos.shopofphotos.domain.photo.PhotoJpaRepository;
import pl.shopofphotos.shopofphotos.domain.photo.entity.PhotoEntity;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class PhotoServiceTest {
  private static final long PHOTO_EXISTING_ID = 1L;
  private static final long PHOTO_NON_EXISTING_ID = 5L;

  private AutoCloseable autoCloseable;
  @Mock
  private PhotoJpaRepository photoJpaRepository;

  @Mock
  private PhotoEntity photoEntity;

  private PhotoService photoService;

  @BeforeAll
  public void setUp() {
    autoCloseable = MockitoAnnotations.openMocks(this);
    photoService = new PhotoService(photoJpaRepository);
  }

  @AfterAll
  public void tearDown() throws Exception {
    autoCloseable.close();
  }

  // this test mocks repository
  @Test
  void shouldReturnPhotos() {
    // given
    when(photoJpaRepository.findAll()).thenReturn(List.of());

    //when
    var photos = photoService.getPhotos();

    // then
    assertEquals(0, photos.size());
  }

  // this test mocks repository
  @Test
  public void shouldReturnPhoto() {
    // given
    when(photoJpaRepository.findById(PHOTO_EXISTING_ID)).thenReturn(Optional.of(photoEntity));

    //when
    var photo = photoService.getPhoto(1L);

    // then
    assertNotNull(photo);
  }

  // this test mocks repository
  @Test
  public void shouldThrowExceptionWhenNoPhotoFound() {
    // given
    when(photoJpaRepository.findById(PHOTO_NON_EXISTING_ID))
        .thenReturn(Optional.ofNullable(null));

    // when
    assertThrows(
        NoPhotoException.class,
        () -> photoService.getPhoto(PHOTO_NON_EXISTING_ID),
        "no photo with id " + PHOTO_NON_EXISTING_ID);
  }
}
