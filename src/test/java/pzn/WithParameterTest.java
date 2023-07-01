package pzn;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class WithParameterTest {
  private Calculator calculator = new Calculator();

  @DisplayName("Percobaan Test")
  @ParameterizedTest(name = "{displayName} dengan parameter {0}")
  @ValueSource(ints = {1, 34, 45, 23, 567})
  void usingParameter(int value) {
    int expected = value + value;
    int result = calculator.add(value, value);
    Assertions.assertEquals(expected, result);
  }
}


