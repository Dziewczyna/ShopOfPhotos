package pl.shopofphotos.shopofphotos.service.person;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import pl.shopofphotos.shopofphotos.domain.person.entity.PersonEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ActiveProfiles("test")
@SpringBootTest
@ExtendWith(SpringExtension.class)
public class PersonServiceIntegrationTest {
    @Autowired
    private PersonService personService;

    @Test
    void shouldReturnPersons(){
        //given & when
        var persons = personService.getPersons();

        //then
        assertEquals(2, persons.size());
        assertPerson(persons.get(0),1,"Katarzyna", "Marchewka");
        assertPerson(persons.get(1),2,"Tomasz", "McVay");
    }

    private void assertPerson(PersonEntity personEntity, int expectedId, String firstName, String lastName){
        assertEquals(expectedId, personEntity.getPersonId());
        assertNotNull(personEntity.getAddress());
        assertEquals(firstName, personEntity.getFirstName());
        assertEquals(lastName, personEntity.getLastName());
    }
}
