package pl.shopofphotos.shopofphotos.domain.dimension.change_dimension;

import pl.shopofphotos.shopofphotos.domain.dimension.Dimension;
import pl.shopofphotos.shopofphotos.domain.dimension.NoDimensionException;

public class OnlineChangeDimension implements ChangeDimensionWay {
  @Override
  public Dimension changeDimension(Dimension dimension) {
    checkDimension(dimension);
    System.out.println("Changing dimension online...");
    return dimension;
  }

  private void checkDimension(Dimension dimension) {
    if (dimension == null) {
      throw new NoDimensionException("No dimension to add!");
    }
  }
}
