package coderbyte.mars;

import java.util.ArrayList;
import java.util.List;

public class Plateau {

  private int sizeX;
  private int sizeY;

  public Plateau(int sizeX, int sizeY) {
    this.sizeX = sizeX;
    this.sizeY = sizeY;
  }

  private List<Rover> rovers = new ArrayList<>();

  public int getSizeX() {
    return sizeX;
  }

  public int getSizeY() {
    return sizeY;
  }

  public List<Rover> getRovers() {
    return rovers;
  }
}
