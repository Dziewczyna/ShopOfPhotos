package pl.shopofphotos.shopofphotos.domain.person.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import pl.shopofphotos.shopofphotos.domain.person.Country;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Table(name = "person")
@Getter
public class PersonEntity {
  @Id
  @Column(name = "person_id")
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long personId;

  @OneToOne(cascade = CascadeType.MERGE)
  @JoinColumn(name = "address_id", referencedColumnName = "address_id")
  private long address;

  @Column(name = "first_name")
  private String firstName;

  @Column(name = "last_name")
  private String lastName;

  @Column(name = "street")
  private String street;

  @Column(name = "city")
  private String city;

  @Column(name = "state")
  private String state;

  @Column(name = "postal_code")
  private String postalCode;

  @Column(name = "country")
  private Country country;

  public PersonEntity(long personId, long address, String firstName, String lastName) {
    this.personId = personId;
    this.address = address;
    this.firstName = firstName;
    this.lastName = lastName;
  }

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
