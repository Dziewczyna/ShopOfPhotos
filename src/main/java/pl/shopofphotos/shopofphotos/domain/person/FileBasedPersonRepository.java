package pl.shopofphotos.shopofphotos.domain.person;

import pl.shopofphotos.shopofphotos.domain.UuidRepository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.HashSet;

import static java.lang.String.format;

public class FileBasedPersonRepository implements PersonRepository {
  private static final String NEW_LINE = System.lineSeparator();
  public final String PERSONS_FILE_PATH = "shopofphotos\\csvfiles\\Persons.csv";

  @Override
  public String addPerson(String firstName, String lastName, Address address) {
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
    return personNumber;
  }

  @Override
  public void readPersons() {
    try {
      BufferedReader reader = new BufferedReader(new FileReader(PERSONS_FILE_PATH));
      String currentLine = reader.readLine();
      System.out.println(currentLine);
      reader.close();

    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public String readPerson(String personNumber) {
    String person = "";
    try {
      person =
          Files.lines(Paths.get(PERSONS_FILE_PATH))
              .filter(u -> u.startsWith(personNumber))
              .toString();
      System.out.printf("Person with %s found in file%n", personNumber);

    } catch (IOException e) {
      e.printStackTrace();
    }
    return person;
  }

  private StringBuilder formatDataToFile(
      String personNumber, String firstName, String lastName, Address address) {
    return new StringBuilder()
        .append(personNumber)
        .append(firstName)
        .append(lastName)
        .append(address)
        .append(NEW_LINE);
  }

  @Override
  public Person editPerson(String firstName, String lastName, String address) {
    return null;
  }

  @Override
  public void deletePerson(String firstName, String lastName, Address address) {
    //    String personToSearchFormatted = formatDataToFile(firstName, lastName, address);
    try {
      BufferedReader reader = new BufferedReader(new FileReader(PERSONS_FILE_PATH));
      String line2 = reader.readLine();

      // hashset for storing lines of file
      HashSet<String> hs = new HashSet<>();

      // loop for each line of file
      while (line2 != null) {
        hs.add(line2);

        line2 = reader.readLine();
      }

    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
