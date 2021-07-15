package pl.shopofphotos.shopofphotos.domain.photo;

import pl.shopofphotos.shopofphotos.domain.Category;
import pl.shopofphotos.shopofphotos.domain.PlaceOfPhoto;
import pl.shopofphotos.shopofphotos.domain.author.Author;
import pl.shopofphotos.shopofphotos.domain.camera.Camera;
import pl.shopofphotos.shopofphotos.domain.dimension.Dimension;
import pl.shopofphotos.shopofphotos.domain.price.Price;
import pl.shopofphotos.shopofphotos.domain.resolution.Resolution;

public class Photo {
    private Camera camera;
    private Resolution resolution;
    private Dimension dimension;
    private PlaceOfPhoto placeOfPhoto;
    private Category category;
    private Price price;
    private Author author;
}
