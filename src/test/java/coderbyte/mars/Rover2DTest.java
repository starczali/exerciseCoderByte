package coderbyte.mars;

import static org.assertj.core.api.Assertions.assertThat;

import javax.naming.OperationNotSupportedException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Rover2DTest {

  private Rover2D rover2D;

  @BeforeEach
  public void init() {
    rover2D = new Rover2D(2, 2, Orientation.N);
    rover2D.setSizeX(5);
    rover2D.setSizeY(5);
  }

  @Test
  void move() {
    // given
    //rover in (2,2) facing N

    // when
    rover2D.move();
    rover2D.move();

    // then rover in (4,2) facing N
    assertThat(rover2D.getCoordonateX()).isEqualTo(2);
    assertThat(rover2D.getCoordonateY()).isEqualTo(4);
    assertThat(rover2D.getOrientation()).isEqualTo(Orientation.N);
  }

  @Test
  void fullTurnLeft() {
    // given
    //rover in (2,2) facing N

    // when
    rover2D.turnLeft();
    rover2D.turnLeft();
    rover2D.turnLeft();
    rover2D.turnLeft();

    // then rover in (2,2) facing N
    assertThat(rover2D.getCoordonateX()).isEqualTo(2);
    assertThat(rover2D.getCoordonateY()).isEqualTo(2);
    assertThat(rover2D.getOrientation()).isEqualTo(Orientation.N);
  }

  @Test
  void fullTurnRight() {
    // given
    // rover in (2,2) facing N

    // when
    rover2D.turnRight();
    rover2D.turnRight();
    rover2D.turnRight();
    rover2D.turnRight();

    // then rover in (2,2) facing N
    assertThat(rover2D.getCoordonateX()).isEqualTo(2);
    assertThat(rover2D.getCoordonateY()).isEqualTo(2);
    assertThat(rover2D.getOrientation()).isEqualTo(Orientation.N);
  }

  @Test
  void executeCommand_testCaseInvalid() {
    // given (1,2) facing N

    Assertions.assertThrows(OperationNotSupportedException.class, () -> {
      // when executing LMLMLMLMM
      rover2D.executeCommand("LMLMLMXMM");
    });
  }

  @Test
  void executeCommand_testCaseNull() throws OperationNotSupportedException {
    // given (2,2) facing N

    rover2D.executeCommand(null);

    // then rover in (2,2) facing N
    System.out.println(rover2D.prettyStatus());
    assertThat(rover2D.getCoordonateX()).isEqualTo(2);
    assertThat(rover2D.getCoordonateY()).isEqualTo(2);
    assertThat(rover2D.getOrientation()).isEqualTo(Orientation.N);
  }

  @Test
  void executeCommand_testCase1() throws OperationNotSupportedException {
    // given (1,2) facing N
    rover2D.setCoordonateX(1);
    rover2D.setCoordonateY(2);
    rover2D.setOrientation(Orientation.N);

    // when executing LMLMLMLMM
    rover2D.executeCommand("LMLMLMLMM");

    // then rover in (1,3) facing N
    System.out.println(rover2D.prettyStatus());
    assertThat(rover2D.getCoordonateX()).isEqualTo(1);
    assertThat(rover2D.getCoordonateY()).isEqualTo(3);
    assertThat(rover2D.getOrientation()).isEqualTo(Orientation.N);
  }

  @Test
  void executeCommand_testCase2() throws OperationNotSupportedException {
    // given (3,3) facing E
    rover2D.setCoordonateX(3);
    rover2D.setCoordonateY(3);
    rover2D.setOrientation(Orientation.E);

    // when executing MMRMMRMRRM
    rover2D.executeCommand("MMRMMRMRRM");

    // then rover in (5,1) facing E
    System.out.println(rover2D.prettyStatus());
    assertThat(rover2D.getCoordonateX()).isEqualTo(5);
    assertThat(rover2D.getCoordonateY()).isEqualTo(1);
    assertThat(rover2D.getOrientation()).isEqualTo(Orientation.E);
  }
}