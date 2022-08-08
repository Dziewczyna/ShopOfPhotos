package pl.shopofphotos.shopofphotos.domain.person.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pl.shopofphotos.shopofphotos.domain.address.entity.AddressEntity;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "person")
@Getter
public class PersonEntity {
  @Id
  @Column(name = "person_id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long personId;

  @OneToOne(
          cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.DETACH},
          fetch = FetchType.EAGER)
  @JoinColumn(name = "address_id", referencedColumnName = "address_id")
  @Enumerated(EnumType.STRING)
  private AddressEntity address;

  @Column(name = "first_name")
  private String firstName;

  @Column(name = "last_name")
  private String lastName;

  @Override
  public String toString() {
    return "PersonEntity{"
        + "personId="
        + personId
        + ", addressId="
        + address
        + ", firstName='"
        + firstName
        + '\''
        + ", lastName='"
        + lastName
        + '\''
        + '}';
  }
}
