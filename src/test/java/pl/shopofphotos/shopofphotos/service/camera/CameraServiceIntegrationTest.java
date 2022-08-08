package pl.shopofphotos.shopofphotos.service.camera;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import pl.shopofphotos.shopofphotos.domain.camera.entity.CameraEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ActiveProfiles("test")
@SpringBootTest
@ExtendWith(SpringExtension.class)
public class CameraServiceIntegrationTest {
    @Autowired
    private CameraService cameraService;

    @Test
    void shouldReturnCameras(){
        //given & when
        var cameras = cameraService.getCameras();

        //then
        assertEquals(2, cameras.size());
        assertCamera(cameras.get(0),1,"SONY", "ZV-1");
        assertCamera(cameras.get(1),2,"SONY", "Cyber-shot DSC-RX100 III");

    }

    private void assertCamera(CameraEntity cameraEntity, int expectedId, String expectedBrand, String expectedModel){
        assertEquals(expectedId, cameraEntity.getCameraId());
        assertEquals(expectedBrand, cameraEntity.getBrand());
        assertEquals(expectedModel, cameraEntity.getModel());
    }
}
