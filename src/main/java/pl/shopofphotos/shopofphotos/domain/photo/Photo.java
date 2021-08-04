package pl.shopofphotos.shopofphotos.domain.photo;

import pl.shopofphotos.shopofphotos.domain.Category;
import pl.shopofphotos.shopofphotos.domain.PlaceOfPhoto;
import pl.shopofphotos.shopofphotos.domain.dimension.Dimension;
import pl.shopofphotos.shopofphotos.domain.person.Person;
import pl.shopofphotos.shopofphotos.domain.camera.Camera;
import pl.shopofphotos.shopofphotos.domain.price.Price;
import pl.shopofphotos.shopofphotos.domain.resolution.Resolution;

public class Photo {
    private Camera camera;
    private Resolution resolution;
    private Dimension dimension;
    private PlaceOfPhoto placeOfPhoto;
    private Category category;
    private Price price;
    private Person author;

    private Photo(PhotoBuilder photoBuilder) {
        this.camera = photoBuilder.camera;
        this.resolution = photoBuilder.resolution;
        this.dimension = photoBuilder.dimension;
        this.placeOfPhoto = photoBuilder.placeOfPhoto;
        this.category = photoBuilder.category;
        this.price = photoBuilder.price;
        this.author = photoBuilder.author;
    }

    @Override
    public String toString() {
        return "Photo{" +
                "camera=" + camera +
                ", resolution=" + resolution +
                ", dimension=" + dimension +
                ", placeOfPhoto=" + placeOfPhoto +
                ", category=" + category +
                ", price=" + price +
                ", author=" + author +
                '}';
    }

    public static class PhotoBuilder{
        private Camera camera;
        private Resolution resolution;
        private Dimension dimension;
        private PlaceOfPhoto placeOfPhoto;
        private Category category;
        private Price price;
        private Person author;

        public PhotoBuilder camera(Camera camera){
            this.camera = camera;
            return this;
        }

        public PhotoBuilder resolution(Resolution resolution){
            this.resolution = resolution;
            return this;
        }

        public PhotoBuilder dimension(Dimension dimension){
            this.dimension = dimension;
            return this;
        }
        public PhotoBuilder placeOfPhoto(PlaceOfPhoto placeOfPhoto){
            this.placeOfPhoto = placeOfPhoto;
            return this;
        }

        public PhotoBuilder category(Category category){
            this.category = category;
            return this;
        }

        public PhotoBuilder price(Price price){
            this.price = price;
            return this;
        }

        public PhotoBuilder author(Person author){
            this.author = author;
            return this;
        }

        public Photo build(){
            return new Photo(this);
        }
    }
}
