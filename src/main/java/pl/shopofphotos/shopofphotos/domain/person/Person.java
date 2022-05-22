package pl.shopofphotos.shopofphotos.domain.person;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@Getter
@Entity
@Table(name = "person")
@NoArgsConstructor
public class Person {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "person_id")
  private long personId;

  @Column(name = "first_name")
  private String firstName;

  @Column(name = "last_name")
  private String lastName;

  @OneToOne(cascade = CascadeType.PERSIST)
  @JoinColumn(name = "address_id", referencedColumnName = "address_id")
  private Address address;

  @Override
  public String toString() {
    return firstName + ";" + lastName + ";" + address;
  }
}
