package agh.ics.oop;

import agh.ics.oop.model.*;
import agh.ics.oop.model.util.MapVisualizer;

import static agh.ics.oop.OptionsParser.parse;

import java.util.List;

public class World {
    public static void main(String[] args) {
        List<MoveDirection> directions = OptionsParser.parse(args);
        List<Vector2d> positions = List.of(new Vector2d(2,1), new Vector2d(3,3));
        GrassField worldMap = new GrassField(10);
//        WorldMap worldMap = new RectangularMap(5,5);
        Simulation simulation = new Simulation(positions, directions, worldMap);
        simulation.run();

//        System.out.println("test");
//        Animal animal = new Animal();
//        System.out.println(animal.getCoordinates());

//        Vector2d position1 = new Vector2d(1,2);
//        System.out.println(position1);
//        Vector2d position2 = new Vector2d(-2,1);
//        System.out.println(position2);
//        System.out.println(position1.add(position2));
//
//        MapDirection mapDir = MapDirection.NORTH;
//        System.out.println(mapDir.toString());
//        System.out.println(mapDir.next());
//        System.out.println(mapDir.previous());
//        System.out.println(mapDir.toUnitVector());
//
//        System.out.println("Start");
//
//        List<MoveDirection> moveDirections = parser(args);
//        run(moveDirections);
//        System.out.println("Stop");

//          List<MoveDirection> directions = OptionsParser.parse(args);
//          List<Vector2d> positions = List.of(new Vector2d(2,2), new Vector2d(3,4));
//          Simulation simulation = new Simulation(positions, directions);
//          simulation.run();
    }

    public static void run(List<MoveDirection> args){

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
