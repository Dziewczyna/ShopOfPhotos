package pl.shopofphotos.shopofphotos.service.price;

import org.springframework.stereotype.Service;
import pl.shopofphotos.shopofphotos.domain.price.Price;
import pl.shopofphotos.shopofphotos.domain.price.PriceJpaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PriceService {
  private PriceJpaRepository priceJpaRepository;

  public List<Price> getPrices() {
    return priceJpaRepository.findAll();
  }

  public Price getPrice(String priceId) {
    Optional<Price> price = priceJpaRepository.findById(priceId);
    if (price.isEmpty()) {
      throw new IllegalArgumentException("No price with id " + priceId);
    }
    return price.get();
  }
}
