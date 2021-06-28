package coderbyte.mars;

import coderbyte.mars.exception.MoveNotPossibleException;
import javax.naming.OperationNotSupportedException;

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

  public void move() {
    validateMove();
    switch (orientation) {
      case E:
        coordonateX--;
        break;
      case S:
        coordonateY--;
        break;
      case W:
        coordonateX++;
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
        orientation = Orientation.N;
        break;
      case S:
        orientation = Orientation.E;
        break;
      case W:
        orientation = Orientation.S;
        break;
      case N:
        orientation = Orientation.W;
        break;
      default:
        break;
    }
  }

  public void executeCommand(String command) throws OperationNotSupportedException {
    for (int i=0; i < command.length(); i++) {
      char singleCommandCode = command.charAt(i);
      switch (singleCommandCode) {
        case 'L':
          turnLeft();
          break;
        case 'R':
          turnRight();
          break;
        case 'M':
          move();
        default:
          throw new OperationNotSupportedException(String.format("Command not supported. Command:" + singleCommandCode));
      }
    }
  }

  private void validateMove() {
    if ((coordonateX == 0 && Orientation.W.equals(orientation)) ||
        (coordonateX == sizeX && Orientation.E.equals(orientation)) ||
        (coordonateY == 0 && Orientation.S.equals(orientation)) ||
        (coordonateY == sizeY && Orientation.N.equals(orientation))) {
      throw new MoveNotPossibleException("move not possible");
    }
  }

}
