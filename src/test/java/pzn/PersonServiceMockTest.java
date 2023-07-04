package pzn;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.Extensions;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import pzn.mocking.Person;
import pzn.mocking.PersonRepository;
import pzn.mocking.PersonService;

@Extensions({
  @ExtendWith(MockitoExtension.class)
})
public class PersonServiceMockTest {
  @Mock
  private PersonRepository personRepository;

  private PersonService personService;

  @BeforeEach
  void setup() {
    personService = new PersonService(personRepository);
  }

  @Test
  void testGetPersonNotFound() {
    Assertions.assertThrows(IllegalArgumentException.class, () -> {
      personService.get("not found");
    });
  }

  @Test
  void testGetPersonSuccess() {
    // menambah behavior ke mock object
    Mockito.when(personRepository.selectById("idMeran")).thenReturn(new Person("idMeran", "Maruusy"));
    Person person = personService.get("idMeran");

    Assertions.assertNotNull(person);
    Assertions.assertEquals("idMeran", person.getId());
    Assertions.assertEquals("Maruusy", person.getName());
  }
}
