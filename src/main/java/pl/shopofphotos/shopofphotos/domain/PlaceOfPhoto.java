package pl.shopofphotos.shopofphotos.domain;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class PlaceOfPhoto {
  private String city;

  @Override
  public String toString() {
    return "PlaceOfPhoto: " + city;
  }
}
