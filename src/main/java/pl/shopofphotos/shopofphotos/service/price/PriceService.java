package pl.shopofphotos.shopofphotos.service.price;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.shopofphotos.shopofphotos.domain.price.PriceJpaRepository;
import pl.shopofphotos.shopofphotos.domain.price.entity.PriceEntity;

import java.util.List;
import java.util.Optional;

@Service
public class PriceService {
  @Autowired private PriceJpaRepository priceJpaRepository;

  public List<PriceEntity> getPrices() {
    return priceJpaRepository.findAll();
  }

  public PriceEntity getPrice(String priceId) {
    Optional<PriceEntity> priceEntity = priceJpaRepository.findById(Long.valueOf(priceId));
    if (priceEntity.isEmpty()) {
      throw new IllegalArgumentException("No price with id " + priceId);
    }
    return priceEntity.get();
  }

  public long addPrice(PriceEntity priceEntity) {
    return priceJpaRepository.save(priceEntity).getPriceId();
  }

  public void deleteAllPrices() {
    priceJpaRepository.deleteAll();
  }
}
