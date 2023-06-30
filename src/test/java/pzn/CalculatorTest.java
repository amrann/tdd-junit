package pzn;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {
  private Calculator calculator = new Calculator();

  @Test
  public void divideSuccess() {
    Integer result = calculator.divide(100, 10);
    assertEquals(10, result);
  }

  @Test
  public void divideFailed() {
    assertThrows(IllegalArgumentException.class, () -> {
      calculator.divide(100, 0);
    });
  }
}
