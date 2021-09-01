package pl.shopofphotos.shopofphotos.domain.dimension;

public enum Dimension {
  dimension913("9x13"),
  dimension1015("10x15"),
  dimension1318("13x18"),
  dimension1521("15x21");

  private final String dimension;

  Dimension(String dimension) {
    this.dimension = dimension;
  }

  public String getDimension() {
    return dimension;
  }

  @Override
  public String toString() {
    return "Dimension{" + "dimension='" + dimension + '\'' + '}';
  }
}
