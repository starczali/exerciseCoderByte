package coderbyte.mars;

import javax.naming.OperationNotSupportedException;

public class MarsExpedition {

  public static void main(String[] args) throws OperationNotSupportedException {
    //init
    final Plateau plateau = new Plateau(5, 5);
    final Rover rover1 = new Rover(1, 2, Orientation.N);
    final Rover rover2 = new Rover(3, 3, Orientation.E);
    plateau.getRovers().add(rover1);
    plateau.getRovers().add(rover2);

    //execution commands
    final String command1 = "LMLMLMLMM";
    rover1.executeCommand(command1);
    System.out.println(rover1.prettyStatus());

    System.out.println("---------------------------");

    final String command2 = "MMRMMRMRRM";
    rover2.executeCommand(command2);
    System.out.println(rover2.prettyStatus());
  }

}
