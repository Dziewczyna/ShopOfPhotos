package pl.shopofphotos.shopofphotos.domain.resolution;

public enum Resolution {
  RESOLUTION_1051_x_1535("1051 x 1535"),
  RESOLUTION_1205_x_1795("1205 x 1795"),
  RESOLUTION_1500_x_2102("1500 x 2102"),
  RESOLUTION_1795_x_2551("1795 x 2551"),
  RESOLUTION_1199_1801("1199 x 1801");

  private final String resolution;

  Resolution(String resolution) {
    this.resolution = resolution;
  }

  @Override
  public String toString() {
    return resolution;
  }
}
