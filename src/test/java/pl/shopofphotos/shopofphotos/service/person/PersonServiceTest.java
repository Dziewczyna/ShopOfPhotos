package pl.shopofphotos.shopofphotos.service.person;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import pl.shopofphotos.shopofphotos.domain.person.NoPersonException;
import pl.shopofphotos.shopofphotos.domain.person.PersonJpaRepository;
import pl.shopofphotos.shopofphotos.domain.person.entity.PersonEntity;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
@ActiveProfiles("test")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class PersonServiceTest {
    private static final long PERSON_EXISTING_ID=1L;
    private static final long PERSON_NON_EXISTING_ID=5L;

    @Mock
    private PersonJpaRepository personJpaRepository;
    private AutoCloseable autoCloseable;
    @Mock
    private PersonEntity personEntity;
    private PersonService personService;

    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        personService = new PersonService(personJpaRepository);
      }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
      }

   @Test
   public void shouldReturnPersons(){
        //given
        when(personJpaRepository.findAll()).thenReturn(List.of());

        //when
       var persons = personService.getPersons();

       //then
       assertEquals(0, persons.size());
   }

    @Test
   public void shouldReturnPerson(){
        //given
        when(personJpaRepository.findById(PERSON_EXISTING_ID)).thenReturn(Optional.ofNullable(personEntity));

        //when
        var person = personService.getPerson(1L);

        //then
        assertNotNull(person);
    }

    @Test
    public void shouldThrowExceptionWhenNoPersonFound() {
        // given
        when(personJpaRepository.findById(PERSON_NON_EXISTING_ID)).thenReturn(Optional.ofNullable(null));

        // when
        assertThrows(
                NoPersonException.class,
                () -> personService.getPerson(PERSON_NON_EXISTING_ID),
                "no person with id " + PERSON_NON_EXISTING_ID);
    }
}