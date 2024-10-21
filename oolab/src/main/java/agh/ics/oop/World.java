package agh.ics.oop;

import agh.ics.oop.model.MoveDirection;
import static agh.ics.oop.OptionsParser.parser;

public class World {
    public static void main(String[] args) {
        System.out.println("Start");
        MoveDirection[] moveDirections = parser(args);

        run(moveDirections);
        System.out.println("Stop");
    }

    public static void run(MoveDirection[] args){

        for(MoveDirection direction: args){
            switch(direction){
                case FORWARD -> System.out.println("Zwierzak idzie do przodu");
                case BACKWARD -> System.out.println("Zwierzak idzie do tylu");
                case RIGHT -> System.out.println("Zwierzak idzie w prawo");
                case LEFT -> System.out.println("Zwierzak idzie w lewo");
            }
        }

    }
}
