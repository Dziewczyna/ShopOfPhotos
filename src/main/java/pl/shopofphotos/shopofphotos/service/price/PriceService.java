package pl.shopofphotos.shopofphotos.service.price;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.shopofphotos.shopofphotos.domain.price.NoPriceException;
import pl.shopofphotos.shopofphotos.domain.price.PriceJpaRepository;
import pl.shopofphotos.shopofphotos.domain.price.entity.PriceEntity;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class PriceService {
  @Autowired private PriceJpaRepository priceJpaRepository;

  public List<PriceEntity> getPrices() {
    return priceJpaRepository.findAll();
  }

  public PriceEntity getPrice(long priceId) {
    Optional<PriceEntity> priceEntity = priceJpaRepository.findById(priceId);
    if (priceEntity.isEmpty()) {
      throw new NoPriceException("No price with id " + priceId);
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
