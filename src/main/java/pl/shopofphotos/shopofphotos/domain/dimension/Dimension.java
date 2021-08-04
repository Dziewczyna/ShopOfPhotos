package pl.shopofphotos.shopofphotos.domain.dimension;

public enum Dimension {
    dimension913("9x13"),
    dimension1015("10x15"),
    dimension1318("13x18"),
    dimension1521("15x21");

    public String getDimension() {
        return dimension;
    }

    Dimension(String dimension) {
        this.dimension = dimension;
    }

    private final String dimension;
}
