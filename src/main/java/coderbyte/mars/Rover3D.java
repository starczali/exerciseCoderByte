package coderbyte.mars;

public class Rover3D extends Rover2D {

  private int coordonateZ = 0;

  public Rover3D(int coordonateX, int coordonateY, Orientation orientation, int coordonateZ) {
    super(coordonateX, coordonateY, orientation);
    this.coordonateZ = coordonateZ;
  }

  public void executeCommand(){
    //to do
  }

  public void flyUp() {
    coordonateZ++;
  }

  public void flyDown() {
    coordonateZ--;
  }

  public String prettyStatus() {
    String pretty = super.prettyStatus();
    return pretty + "Rover having coordonateZ:" + coordonateZ;
  }

  @Override
  public Integer cost() {
    return super.cost() * 3;
  }
}
