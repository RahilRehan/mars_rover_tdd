import org.junit.jupiter.api.Test;
import rover.Rover;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RoverTest {
    @Test
    void shouldReturnInitialPositionWithNoCommand() {
        int xPos = 1, yPos = 2;
        String direction = "N", commands = "";
        Rover rover = new Rover(xPos, yPos, direction);
        String finalDirection = rover.move(commands);
        assertEquals("1 2 N", finalDirection);
    }

    @Test
    void shouldReturnNextValidPositionWithMoveCommand() {
        int xPos = 1, yPos = 2;
        String direction = "N", commands = "M";
        Rover rover = new Rover(xPos, yPos, direction);
        String finalDirection = rover.move(commands);
        assertEquals("1 3 N", finalDirection);
    }
}
