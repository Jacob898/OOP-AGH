package agh.ics.oop;

import agh.ics.oop.model.*;

import java.util.ArrayList;
import java.util.List;

public class Simulation implements Runnable {

    private final List<Animal> Animals= new ArrayList<>();
    private final List<MoveDirection> Directions;
    private final WorldMap Map;

    public Simulation(List<Vector2d> positions, List<MoveDirection> directions, WorldMap map) {
        this.Map = map;
        this.Directions=directions;
        for (Vector2d position : positions) {
                Animal animal = new Animal(MapDirection.NORTH, position);
            try {
                if(map.place(animal)) {
                    Animals.add(animal);
                }
            } catch (IncorrectPositionException e){
                System.out.println("Warning: " + e.getMessage());
            }
        }

    }

    public void run() {
       int animal_count = Animals.size();

       for(MoveDirection direction : Directions) {
           Animal animal = Animals.getFirst();
           Animals.removeFirst();
           Map.move(animal, direction);
           Animals.add(animal);
       }

    }

    //getter
    public List<Animal> getAnimals() {
        return Animals;
    }
    //getter
    public List<MoveDirection> getDirections() {
        return Directions;
    }

}
