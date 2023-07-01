package pzn;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

public class WithParameterTest {
  private Calculator calculator = new Calculator();
  public static List<Integer> parameterSource() {
    return Arrays.asList(3, 123, 99, 10);
  }

  @DisplayName("Percobaan Test")
  @ParameterizedTest(name = "{displayName} dengan parameter {0}")
  @ValueSource(ints = {1, 34, 45, 23, 567})
  void usingParameter(int value) {
    int expected = value + value;
    int result = calculator.add(value, value);
    Assertions.assertEquals(expected, result);
  }

  @DisplayName("Percobaan Test")
  @ParameterizedTest(name = "{displayName} dengan parameter {0}")
  @MethodSource({"parameterSource"})
  void usingParameterMethodSource(int value) {
    int expected = value + value;
    int result = calculator.add(value, value);
    Assertions.assertEquals(expected, result);
  }
}







