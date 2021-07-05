package coderbyte.mars;

import javax.naming.OperationNotSupportedException;

public class MarsExpedition {

  /*
  Improvement ideas:
  1. use logger instead of System out.
  2. validation of Plateau, plateau must have at least 2 size
  3. plateau can have obstacles, which will make move not possible
  4. plateau can take into consideration the other rovers position
    validating the move should be moved to plateau
  5. moving not only 4 directions, but 8
  6. introducing fuel - rovers can have fuel, simple directions cost 1, diagonal 1.5
  7. introducing 3D structure - for simplest you can have fly method - validation will be
  even more complicated
  8. no obstacles, arriving from one place to other fuel consumption
  9. introducing 3D rovers also by extending 2D Rovers
   */

  public static void main(String[] args) throws OperationNotSupportedException {
    // init
    final Plateau plateau = new Plateau(5, 5);
    final Rover2D rover1 = new Rover2D(1, 2, Orientation.N);
    final Rover2D rover2 = new Rover2D(3, 3, Orientation.E);
    final Rover3D rover3 = new Rover3D(3, 3, Orientation.E, 0);

    plateau.getRovers().add(rover1);
    plateau.getRovers().add(rover2);
    plateau.getRovers().add(rover3);

    // execution commands
    final String command1 = "LMLMLMLMM";
    rover1.executeCommand(command1);
    System.out.println(rover1.prettyStatus());

    System.out.println("---------------------------");

    final String command2 = "MMRMMRMRRM";
    rover2.executeCommand(command2);
    System.out.println(rover2.prettyStatus());

    Integer totalCost = 0;
    for (Rovering rovering : plateau.getRovers()) {
      totalCost += rovering.cost();
    }

    System.out.println(
        "Total cost of expedition having " + plateau.getRovers().size() + " rovers :" + totalCost/1_000_000 + "M.");
  }

}
