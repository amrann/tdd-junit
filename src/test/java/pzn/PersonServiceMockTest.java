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

  @Test
  void testVerifySuccess() {
    Person person = personService.register("Maruusy");
    Assertions.assertNotNull(person); // ngecek person gk boleh null datanya
    Assertions.assertEquals("Maruusy", person.getName());

    // ngecek person harus punya id
    // pada cases ini, idnya sudah dicreate random otomatis
    Assertions.assertNotNull(person.getId());

    // memastikan "insert" pada method register.PersonService, terpanggil
    // memastikan "insert" pada method register.PersonService, cuman dijalankan sekali
    // sehingga jika "insert" pada method register.PersonService ditulis 2x, maka akan muncul error
    Mockito.verify(personRepository, Mockito.times(1))
            .insert(new Person(person.getId(), "Maruusy"));
  }
}
