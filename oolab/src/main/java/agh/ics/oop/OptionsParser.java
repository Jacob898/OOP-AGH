package agh.ics.oop;

import agh.ics.oop.model.MoveDirection;
import java.util.List;
import java.util.ArrayList;

public class OptionsParser {
    public static List<MoveDirection> parse(String[] args){
        List<MoveDirection> moveDirections = new ArrayList<>();

        for (String arg : args) {

            MoveDirection direction = switch (arg) {
                case "f" -> MoveDirection.FORWARD;
                case "b" -> MoveDirection.BACKWARD;
                case "r" -> MoveDirection.RIGHT;
                case "l" -> MoveDirection.LEFT;
                default -> null;
            };
            if (direction != null) {
                moveDirections.add(direction);
            }
        }
        return moveDirections;
    }
}
