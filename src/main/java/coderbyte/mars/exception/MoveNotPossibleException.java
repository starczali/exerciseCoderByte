package coderbyte.mars.exception;

public class MoveNotPossibleException extends RuntimeException{

  public MoveNotPossibleException(String move_not_possible) {
    super(move_not_possible);
  }
}
