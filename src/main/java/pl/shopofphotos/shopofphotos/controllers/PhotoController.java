package pl.shopofphotos.shopofphotos.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.shopofphotos.shopofphotos.domain.photo.Photo;
import lombok.extern.slf4j.Slf4j;
import pl.shopofphotos.shopofphotos.domain.photo.PhotoRepository;

import java.util.List;

@RestController
@Slf4j
public class PhotoController {

//    @Autowired
//    private PhotoRepository photoRepository;
//
//    @GetMapping("/students")
//    public List<Photo> getStudents(){
//        log.info("fetching all students");
//        return photoRepository.findAll();
//    }
}
