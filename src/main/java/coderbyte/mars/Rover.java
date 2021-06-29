package coderbyte.mars;

import coderbyte.mars.exception.MoveNotPossibleException;
import javax.naming.OperationNotSupportedException;
import org.apache.commons.lang3.StringUtils;

public class Rover {

  private int coordonateX;
  private int coordonateY;
  private Orientation orientation;

  private int sizeX = 5;
  private int sizeY = 5;

  public Rover(int coordonateX, int coordonateY, Orientation orientation) {
    this.coordonateX = coordonateX;
    this.coordonateY = coordonateY;
    this.orientation = orientation;
  }


  public void setSizeX(int sizeX) {
    this.sizeX = sizeX;
  }

  public void setSizeY(int sizeY) {
    this.sizeY = sizeY;
  }

  public void setCoordonateX(int coordonateX) {
    this.coordonateX = coordonateX;
  }

  public void setCoordonateY(int coordonateY) {
    this.coordonateY = coordonateY;
  }

  public void setOrientation(Orientation orientation) {
    this.orientation = orientation;
  }

  public int getCoordonateX() {
    return coordonateX;
  }

  public int getCoordonateY() {
    return coordonateY;
  }

  public Orientation getOrientation() {
    return orientation;
  }

  public void move() {
    validateMove();
    switch (orientation) {
      case E:
        coordonateX++;
        break;
      case S:
        coordonateY--;
        break;
      case W:
        coordonateX--;
        break;
      case N:
        coordonateY++;
        break;
      default:
        break;
    }
  }

  public void turnLeft() {
    switch (orientation) {
      case E:
        orientation = Orientation.S;
        break;
      case S:
        orientation = Orientation.W;
        break;
      case W:
        orientation = Orientation.N;
        break;
      case N:
        orientation = Orientation.E;
        break;
      default:
        break;
    }
  }

  public void turnRight() {
    switch (orientation) {
      case E:
        orientation = Orientation.S;
        break;
      case S:
        orientation = Orientation.W;
        break;
      case W:
        orientation = Orientation.N;
        break;
      case N:
        orientation = Orientation.E;
        break;
      default:
        break;
    }
  }

  public void executeCommand(String command) throws OperationNotSupportedException {
    if (StringUtils.isNotBlank(command)) {
      for (int i = 0; i < command.length(); i++) {
        char singleCommandCode = command.charAt(i);
        System.out.println(prettyStatus());
        System.out.println("Executing command: " + singleCommandCode);
        switch (singleCommandCode) {
          case 'L':
            turnLeft();
            break;
          case 'R':
            turnRight();
            break;
          case 'M':
            move();
            break;
          default:
            throw new OperationNotSupportedException(
                String.format("Command not supported. Command:" + singleCommandCode));
        }
      }
    } else {
      System.out.println("Null or blank command cannot be executed");
    }
  }

  private void validateMove() {
    if ((coordonateX == 0 && Orientation.W.equals(orientation)) ||
        (coordonateX == sizeX && Orientation.E.equals(orientation)) ||
        (coordonateY == 0 && Orientation.S.equals(orientation)) ||
        (coordonateY == sizeY && Orientation.N.equals(orientation))) {
      System.out.println("not possible from:" + coordonateX);
      System.out.println("not possible from:" + coordonateY);
      System.out.println("not possible from:" + orientation);
      throw new MoveNotPossibleException("move not possible");
    }
  }

  public String prettyStatus() {
    final String status = String
        .format("Rover having (%s,%s) facing %s", coordonateX, coordonateY, orientation);
    return status;
  }

}
