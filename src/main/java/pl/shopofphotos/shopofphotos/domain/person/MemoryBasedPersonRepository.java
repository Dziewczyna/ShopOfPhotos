package pl.shopofphotos.shopofphotos.domain.person;

import java.io.*;

public class MemoryBasedPersonRepository implements PersonRepository {
  public final String PERSON_FILE_PATH =
      "C:\\Users\\joann\\IdeaProjects\\shopofphotos\\shopofphotos\\src\\main\\resources\\Persons.txt";

  @Override
  public Person addPerson(String firstName, String lastName, Address address) {
    try {
      BufferedWriter writer = new BufferedWriter(new FileWriter(PERSON_FILE_PATH, true));
      writer.write(formatDataToWriteToFile(firstName, lastName, address));
      writer.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return new Person(firstName, lastName, address);
  }

  @Override
  public void readPersons() {
    try {
      BufferedReader reader = new BufferedReader(new FileReader(PERSON_FILE_PATH));
      String currentLine = reader.readLine();
      System.out.println(currentLine);
      reader.close();

    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private String formatDataToWriteToFile(String firstName, String lastName, Address address) {
    return "\n" + firstName + ";" + lastName + ";" + address.toString();
  }

  @Override
  public Person editPerson(String firstName, String lastName, String address) {
    return null;
  }

  @Override
  public void deletePerson(String firstName, String lastName, String address) {}
}
