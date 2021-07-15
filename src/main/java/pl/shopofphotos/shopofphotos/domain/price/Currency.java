package pl.shopofphotos.shopofphotos.domain.price;

public enum Currency {
    PLN("PLN"),
    USD("USD"),
    EUR("EURO"),
    BTC("BITCOIN");

    public String getCurrency() {
        return currency;
    }

    Currency(String currency) {
        this.currency = currency;
    }

    private final String currency;
}
