package pl.shopofphotos.shopofphotos.service.camera;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import pl.shopofphotos.shopofphotos.domain.camera.NoCameraException;
import pl.shopofphotos.shopofphotos.domain.camera.CameraJpaRepository;
import pl.shopofphotos.shopofphotos.domain.camera.entity.CameraEntity;
import pl.shopofphotos.shopofphotos.service.camera.CameraService;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
@ActiveProfiles("test")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CameraServiceTest {
    private static final long CAMERA_EXISTING_ID=1L;
    private static final long CAMERA_NON_EXISTING_ID=5L;

    @Mock
    private CameraJpaRepository cameraJpaRepository;
    private AutoCloseable autoCloseable;
    @Mock
    private CameraEntity cameraEntity;
    private CameraService cameraService;

    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        cameraService = new CameraService(cameraJpaRepository);
      }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
      }

   @Test
   public void shouldReturnCameras(){
        //given
        when(cameraJpaRepository.findAll()).thenReturn(List.of());

        //when
       var cameras = cameraService.getCameras();

       //then
       assertEquals(0, cameras.size());
   }

    @Test
   public void shouldReturnCamera(){
        //given
        when(cameraJpaRepository.findById(CAMERA_EXISTING_ID)).thenReturn(Optional.ofNullable(cameraEntity));

        //when
        var camera = cameraService.getCamera(1L);

        //then
        assertNotNull(camera);
    }

    @Test
    public void shouldThrowExceptionWhenNoCameraFound() {
        // given
        when(cameraJpaRepository.findById(CAMERA_NON_EXISTING_ID)).thenReturn(Optional.ofNullable(null));

        // when
        assertThrows(
                NoCameraException.class,
                () -> cameraService.getCamera(CAMERA_NON_EXISTING_ID),
                "no camera with id " + CAMERA_NON_EXISTING_ID);
    }
}