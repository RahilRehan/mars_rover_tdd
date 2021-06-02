package rover;


import position.Position;

import static utils.Command.*;
import static utils.Direction.*;

public class Rover {

    private Position position;
    private String direction;
    private static final Integer FORWARD=1;
    private static final Integer BACKWARD=-1;


    public Rover(int xPos, int yPos, String direction) {
        this.position = new Position(xPos, yPos);
        this.direction = direction;
    }

    public String process(String commands) {
        for(String command: getSplit(commands))
            switch (command) {
                case MOVE:
                    move(direction);
                    break;
                case RIGHT:
                    turnRight(direction);
                    break;
                case LEFT:
                    turnLeft(direction);
                    break;
                default:
                    return this.toString();
            }
        return this.toString();
    }

    private void move(String direction) {
        switch (direction) {
            case NORTH:
                moveVertical(FORWARD);
                break;
            case SOUTH:
                moveVertical(BACKWARD);
                break;
            case EAST:
                moveHorizontal(FORWARD);
                break;
            default:
                moveHorizontal(BACKWARD);
                break;
        }
    }

    private void turnLeft(String direction) {
        switch (direction) {
            case NORTH:
                changeDirection(WEST);
                break;
            case SOUTH:
                changeDirection(EAST);
                break;
            case EAST:
                changeDirection(NORTH);
                break;
            default:
                changeDirection(SOUTH);
                break;
        }
    }

    private void turnRight(String direction) {
        switch (direction) {
            case NORTH:
                changeDirection(EAST);
                break;
            case SOUTH:
                changeDirection(WEST);
                break;
            case EAST:
                changeDirection(SOUTH);
                break;
            default:
                changeDirection(NORTH);
                break;
        }
    }

    private void changeDirection(String newDirection) {
        this.direction = newDirection;
    }

    private void moveHorizontal(Integer direction){
        position = new Position(position.getxPos()+direction, position.getyPos());
    }

    private void moveVertical(Integer direction){
        position = new Position(position.getxPos(), position.getyPos()+direction);
    }

    @Override
    public String toString() {
        return this.position.toString() + " " + this.direction;
    }
}
