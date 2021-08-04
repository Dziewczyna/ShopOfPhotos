package pl.shopofphotos.shopofphotos.domain.order;

import pl.shopofphotos.shopofphotos.domain.person.Person;
import pl.shopofphotos.shopofphotos.domain.photo.Photo;
import pl.shopofphotos.shopofphotos.domain.price.Price;

import java.util.List;

public class Order {
    public Person buyer;
    public Person author;
    public List<Photo> photos;
    public Price price;
}
