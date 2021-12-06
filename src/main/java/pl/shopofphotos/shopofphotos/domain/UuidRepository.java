package pl.shopofphotos.shopofphotos.domain;

import java.util.UUID;

public class UuidRepository {
  String id = UUID.randomUUID().toString();

  public String getId() {
    return id;
  }
}
