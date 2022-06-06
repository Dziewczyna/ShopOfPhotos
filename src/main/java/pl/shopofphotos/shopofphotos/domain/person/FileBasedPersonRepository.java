package pl.shopofphotos.shopofphotos.domain.person;

import org.springframework.stereotype.Repository;
import pl.shopofphotos.shopofphotos.domain.UuidRepository;
import pl.shopofphotos.shopofphotos.domain.address.Address;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Repository
public class FileBasedPersonRepository implements PersonRepository {
  private static final String NEW_LINE = System.lineSeparator();
  public final String PERSONS_FILE_PATH = "csvfiles\\Persons.csv";

  @Override
  public void addPerson(String firstName, String lastName, Address address) {
    UuidRepository uuid = new UuidRepository();
    String personNumber = uuid.getId();
    try {
      Path pathToFile = Paths.get(PERSONS_FILE_PATH);
      Files.writeString(
          pathToFile,
          formatDataToFile(personNumber, firstName, lastName, address),
          StandardOpenOption.CREATE,
          StandardOpenOption.APPEND);
      System.out.printf("%s %s added to the file%n", firstName, lastName);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void readPersons() {
    try (Stream<String> stream = Files.lines(Paths.get(PERSONS_FILE_PATH))) {
      stream.forEach(System.out::println);

    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Override
  public String getPersonNumber(int i) {
    String extractedLine;
    String personNumber = "";
    try {
      extractedLine = Files.readAllLines(Paths.get(PERSONS_FILE_PATH)).get(i);
      personNumber = extractedLine.substring(0, extractedLine.indexOf(";"));
    } catch (IOException e) {
      e.printStackTrace();
    }

    return personNumber;
  }

  private String findPersonByName(String firstName, String lastName) {
    String person = "";
    try {
      person =
          Files.lines(Paths.get(PERSONS_FILE_PATH))
              .filter(u -> u.contains(firstName) & u.contains(lastName))
              .toString();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return person;
  }

  @Override
  public String readPerson(String firstName, String lastName) {
    return findPersonByName(firstName, lastName);
  }

  private StringBuilder formatDataToFile(
      String personNumber, String firstName, String lastName, Address address) {
    return new StringBuilder()
        .append(personNumber)
        .append("; ")
        .append(firstName)
        .append("; ")
        .append(lastName)
        .append("; ")
        .append(address)
        .append(NEW_LINE);
  }

  @Override
  public void editPerson(String firstName, String lastName, Address address) {
    deletePerson(firstName, lastName);
    addPerson(firstName, lastName, address);
  }

  @Override
  public void deletePerson(String firstName, String lastName) {
    Path pathToFile = Paths.get(PERSONS_FILE_PATH);
    try {
      List<String> out =
          Files.lines(pathToFile)
              .filter(line -> !line.contains(firstName) & !line.contains(lastName))
              .collect(Collectors.toList());
      Files.write(pathToFile, out, StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING);
      System.out.println(firstName + " " + lastName + " deleted");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
