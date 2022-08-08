package pl.shopofphotos.shopofphotos.service.photo;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import pl.shopofphotos.shopofphotos.domain.Category;
import pl.shopofphotos.shopofphotos.domain.photo.entity.PhotoEntity;
import pl.shopofphotos.shopofphotos.domain.resolution.Resolution;

@ActiveProfiles("test")
@SpringBootTest
@ExtendWith(SpringExtension.class)
public class PhotoServiceIntegrationTest {

    @Autowired
    private PhotoService photoService;

    // this test uses test database
    @Test
    void shouldReturnPhotos() {
        // given & when
        var photos = photoService.getPhotos();

        // then
        assertEquals(2, photos.size());
        assertPhoto(photos.get(0), 1, "Photo details 1",
                "Lublin", "1", Category.HUMAN, Resolution.RESOLUTION_1500_x_2102);

        assertPhoto(photos.get(1), 2, "Photo details 2",
                "Warszawa", "2", Category.ARCHITECTURE, Resolution.RESOLUTION_1795_x_2551);
    }

    private void assertPhoto(PhotoEntity photo, int expectedId, String expectedPhotoDetails, String expectedPlace,
                             String expectedAuthorId, Category expectedCategory, Resolution expectedResolution) {
        assertEquals(expectedId, photo.getPhotoId());
        assertEquals(expectedPhotoDetails, photo.getPhotoDetails());
        assertEquals(expectedPlace, photo.getPlaceOfPhoto());
        assertEquals(expectedAuthorId, photo.getAuthorId());
        assertNotNull(photo.getOrders());
        assertNotNull(photo.getCameraEntity());
        assertEquals(expectedCategory, photo.getCategory());
        assertEquals(expectedResolution, photo.getResolution());
        assertNotNull(photo.getPrice());
    }
}
