package pzn.mocking;

public class PersonService {

  // penanda PersonService ketergantungan terhadap PersonRepository
  private PersonRepository personRepository;

  public PersonService(PersonRepository personRepository) {
    this.personRepository = personRepository;
  }

  public Person get(String id) {
    Person person = personRepository.selectById(id);
    if (person != null) {
      return person;
    } else {
      throw new IllegalArgumentException("Person tidak ditemukan");
    }
  }
}
