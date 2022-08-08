package pl.shopofphotos.shopofphotos.service.address;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.shopofphotos.shopofphotos.domain.address.AddressJpaRepository;
import pl.shopofphotos.shopofphotos.domain.address.NoAddressException;
import pl.shopofphotos.shopofphotos.domain.address.entity.AddressEntity;
import pl.shopofphotos.shopofphotos.domain.exception.ResourceNotFoundException;

import java.util.List;

@AllArgsConstructor
@Service
public class AddressService {
  @Autowired private AddressJpaRepository addressJpaRepository;

  public List<AddressEntity> getAddresses() {
    return addressJpaRepository.findAll();
  }

  public AddressEntity getAddress(long addressId){
    return addressJpaRepository
        .findById(addressId)
        .orElseThrow(
            () -> new NoAddressException("Address not found for this id: " + addressId));
  }

  public AddressEntity createAddressEntity(AddressEntity addressEntity) {
    return addressJpaRepository.save(addressEntity);
  }

  public Boolean deleteAddressEntity(Long addressId){
    AddressEntity addressEntity =
        addressJpaRepository
            .findById(addressId)
            .orElseThrow(
                () -> new NoAddressException("Address not found for this id: " + addressId));

    addressJpaRepository.delete(addressEntity);
    return true;
  }

  public Boolean deleteAllAddresses() {
    addressJpaRepository.deleteAll();
    return true;
  }
}
