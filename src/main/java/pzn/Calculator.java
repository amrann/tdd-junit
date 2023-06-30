package pzn;

public class Calculator {
  public Integer divide(Integer first, Integer second) {
    if (second == 0) {
      throw new IllegalArgumentException("Cannot divide by zero");
    } else {
      return first / second;
    }
  }
}
