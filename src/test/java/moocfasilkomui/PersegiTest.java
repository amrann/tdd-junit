package moocfasilkomui;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PersegiTest {
  @Test
  public void testLuas() {
    Persegi pLuas = new Persegi();
    pLuas.setPanjang(5);
    pLuas.setLebar(6);

    assertEquals(30, pLuas.getLuas());
  }

  @Test
  public void testKeliling() {
    Persegi pKeliling = new Persegi();
    pKeliling.setPanjang(5);
    pKeliling.setLebar(6);

    assertEquals(22, pKeliling.getKeliling());
  }

}
