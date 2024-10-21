package agh.ics.oop;

import agh.ics.oop.model.MoveDirection;

import java.util.Arrays;

public class OptionsParser {
    public static MoveDirection[] parser(String[] args){
        MoveDirection[] moveDirections = new MoveDirection[args.length];
        int index=0;
        for (String arg : args) {

            MoveDirection direction = switch (arg) {
                case "f" -> MoveDirection.FORWARD;
                case "b" -> MoveDirection.BACKWARD;
                case "r" -> MoveDirection.RIGHT;
                case "l" -> MoveDirection.LEFT;
                default -> null;
            };
            if (direction != null) {
                moveDirections[index] = direction;
                index++;
            }

        }
        return Arrays.copyOf(moveDirections, index);
    }
}
