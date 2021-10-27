package pl.shopofphotos.shopofphotos.domain.person;

import java.io.*;
import java.util.HashSet;

import static java.lang.String.format;

public class FileBasedPersonRepository implements PersonRepository {
  public final String PERSONS_FILE_PATH = "shopofphotos\\src\\main\\resources\\Persons.csv";

  @Override
  public Person addPerson(String firstName, String lastName, Address address) {
    try {
      BufferedWriter writer = new BufferedWriter(new FileWriter(PERSONS_FILE_PATH, true));
      writer.write(formatDataToFile(firstName, lastName, address));
      System.out.println(format("%s %s added to the file", firstName, lastName));
      writer.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return new Person(firstName, lastName, address);
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

  private String formatDataToFile(String firstName, String lastName, Address address) {
    return "\n" + firstName + ";" + lastName + ";" + address.toString();
  }

  @Override
  public Person editPerson(String firstName, String lastName, String address) {
    return null;
  }

  @Override
  public void deletePerson(String firstName, String lastName, Address address) {
    String personToSearchFormatted = formatDataToFile(firstName, lastName, address);
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
