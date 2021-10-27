package pl.shopofphotos.shopofphotos.domain.resolution;

public enum Resolution {
  resolution1051("1051 x 1535"),
  resolution1205("1205 x 1795"),
  resolution1500("1500 x 2102"),
  resolution1795("1795 x 2551"),
  resolution1199("1199 x 1801");

  private final String resolution;

  Resolution(String resolution) {
    this.resolution = resolution;
  }

  @Override
  public String toString() {
    return resolution;
  }
}
