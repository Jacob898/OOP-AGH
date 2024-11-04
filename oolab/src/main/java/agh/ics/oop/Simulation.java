package agh.ics.oop;

import agh.ics.oop.model.Animal;
import agh.ics.oop.model.MapDirection;
import agh.ics.oop.model.MoveDirection;
import agh.ics.oop.model.Vector2d;

import java.util.ArrayList;
import java.util.List;

public class Simulation {

    private List<Animal> animals;
    private List<MoveDirection> directions;
    private int currentMoveIndex;

    public Simulation(List<Vector2d> coordinates, List<MoveDirection> directions) {
        this.animals = new ArrayList<>();
        for (Vector2d coordinate : coordinates) {
            animals.add(new Animal(MapDirection.NORTH, coordinate));
        }
        this.currentMoveIndex=0;
        this.directions=directions;
    }

    //getter
    public List<Animal> getAnimals() {
        return this.animals;
    }

    public void run() {
        while(currentMoveIndex < directions.size()) {
                for (int i = 0; i < animals.size(); i++) {
                    if(currentMoveIndex >= directions.size()) {
                        break;
                    }
                    MoveDirection movement = directions.get(currentMoveIndex);
                    animals.get(i).move(movement);
                    System.out.println(animals.get(i).toString(i));
                    currentMoveIndex++;
                }
        }
    }
}
