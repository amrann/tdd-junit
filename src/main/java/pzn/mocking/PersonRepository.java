package pzn.mocking;

public interface PersonRepository {
  Person selectById(String id);

  void insert(Person person);
}
