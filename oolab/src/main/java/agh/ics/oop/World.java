package agh.ics.oop;

import agh.ics.oop.model.*;

import java.util.ArrayList;
import java.util.List;

public class World {
    public static void main(String[] args) {

        try {
//            List<MoveDirection> directions = OptionsParser.parse(args);
//            List<Vector2d> positions = List.of(new Vector2d(2,1), new Vector2d(3,3));
//            AbstractWorldMap map1 = new GrassField(10);
//            AbstractWorldMap map2 = new RectangularMap(5,5);
//            map1.addObserver(new ConsoleMapDisplay());
//            map2.addObserver(new ConsoleMapDisplay());
//            Simulation simulation1 = new Simulation(positions, directions, map1);
//            Simulation simulation2 = new Simulation(positions, directions, map2);
//            SimulationEngine engine = new SimulationEngine(List.of(simulation1, simulation2));
////            engine.runSync();
//            engine.runAsync();
////            simulation.run();
            List<MoveDirection> directions = OptionsParser.parse(args);
            List<Vector2d> positions = List.of(new Vector2d(2,2), new Vector2d(3,4));
            List<Simulation> simulations = new ArrayList<>();

            for (int i = 0; i < 3; i++) {
                AbstractWorldMap map = i % 2 == 0 ? new GrassField(10) : new RectangularMap(5, 5);
                map.addObserver(new ConsoleMapDisplay());
                Simulation simulation = new Simulation(positions, directions, map);
                simulations.add(simulation);
            }

            SimulationEngine engine = new SimulationEngine(simulations);
            engine.runAsyncInThreadPool();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }


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
        System.out.println("System zakończył działanie");

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
