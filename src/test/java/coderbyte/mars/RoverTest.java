package coderbyte.mars;

import static org.assertj.core.api.Assertions.assertThat;

import javax.naming.OperationNotSupportedException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RoverTest {

  private Rover rover;

  @BeforeEach
  public void init() {
    rover = new Rover(2, 2, Orientation.N);
    rover.setSizeX(5);
    rover.setSizeX(5);
  }

  @Test
  void move() {
    // given
    //rover in (2,2) facing N

    // when
    rover.move();
    rover.move();

    // then rover in (4,2) facing N
    assertThat(rover.getCoordonateX()).isEqualTo(2);
    assertThat(rover.getCoordonateY()).isEqualTo(4);
    assertThat(rover.getOrientation()).isEqualTo(Orientation.N);
  }

  @Test
  void fullTurnLeft() {
    // given
    //rover in (2,2) facing N

    // when
    rover.turnLeft();
    rover.turnLeft();
    rover.turnLeft();
    rover.turnLeft();

    // then rover in (2,2) facing N
    assertThat(rover.getCoordonateX()).isEqualTo(2);
    assertThat(rover.getCoordonateY()).isEqualTo(2);
    assertThat(rover.getOrientation()).isEqualTo(Orientation.N);
  }

  @Test
  void fullTurnRight() {
    // given
    // rover in (2,2) facing N

    // when
    rover.turnRight();
    rover.turnRight();
    rover.turnRight();
    rover.turnRight();

    // then rover in (2,2) facing N
    assertThat(rover.getCoordonateX()).isEqualTo(2);
    assertThat(rover.getCoordonateY()).isEqualTo(2);
    assertThat(rover.getOrientation()).isEqualTo(Orientation.N);
  }

  @Test
  void executeCommand_testCaseInvalid() {
    // given (1,2) facing N

    Assertions.assertThrows(OperationNotSupportedException.class, () -> {
      // when executing LMLMLMLMM
      rover.executeCommand("LMLMLMXMM");
    });
  }

  @Test
  void executeCommand_testCaseNull() throws OperationNotSupportedException {
    // given (2,2) facing N

    rover.executeCommand(null);

    // then rover in (2,2) facing N
    System.out.println(rover.prettyStatus());
    assertThat(rover.getCoordonateX()).isEqualTo(2);
    assertThat(rover.getCoordonateY()).isEqualTo(2);
    assertThat(rover.getOrientation()).isEqualTo(Orientation.N);
  }

  @Test
  void executeCommand_testCase1() throws OperationNotSupportedException {
    // given (1,2) facing N
    rover.setCoordonateX(1);
    rover.setCoordonateY(2);
    rover.setOrientation(Orientation.N);

    // when executing LMLMLMLMM
    rover.executeCommand("LMLMLMLMM");

    // then rover in (1,3) facing N
    System.out.println(rover.prettyStatus());
    assertThat(rover.getCoordonateX()).isEqualTo(1);
    assertThat(rover.getCoordonateY()).isEqualTo(3);
    assertThat(rover.getOrientation()).isEqualTo(Orientation.N);
  }

  @Test
  void executeCommand_testCase2() throws OperationNotSupportedException {
    // given (3,3) facing E
    rover.setCoordonateX(3);
    rover.setCoordonateY(3);
    rover.setOrientation(Orientation.E);

    // when executing MMRMMRMRRM
    rover.executeCommand("MMRMMRMRRM");

    // then rover in (5,1) facing E
    System.out.println(rover.prettyStatus());
    assertThat(rover.getCoordonateX()).isEqualTo(5);
    assertThat(rover.getCoordonateY()).isEqualTo(1);
    assertThat(rover.getOrientation()).isEqualTo(Orientation.E);
  }
}