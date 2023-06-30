package moocfasilkomui;

public class Persegi {
  private int panjang;
  private int lebar;

  public void setPanjang(int panjang) {
    this.panjang = panjang;
  }
  public void setLebar(int lebar) {
    this.lebar = lebar;
  }
  public int getLuas() {
    return panjang * lebar;
  }

  public int getKeliling() {
    return 2 * (panjang + lebar);
  }

}
