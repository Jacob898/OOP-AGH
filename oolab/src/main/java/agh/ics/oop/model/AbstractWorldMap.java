package agh.ics.oop.model;

import agh.ics.oop.model.util.MapVisualizer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class AbstractWorldMap implements WorldMap {
   protected Map<Vector2d,Animal> animals = new HashMap<>();
    protected MapVisualizer visualizer = new MapVisualizer(this);
    protected Vector2d mapBottomLeft = new Vector2d(0, 0);
    protected Vector2d mapTopRight = new Vector2d(0, 0);

    @Override
    public void move(Animal animal, MoveDirection direction) {
        Vector2d position = animal.getPosition();
        animal.move(direction, this);
        animals.remove(position, animal);
        animals.put(animal.getPosition(), animal);
    }
    @Override
    public WorldElement objectAt(Vector2d position) {
        return animals.get(position);
    }
    @Override
    public boolean place(Animal animal) {
        if(canMoveTo(animal.getPosition())) {
            animals.put(animal.getPosition(), animal);
            return true;
        }
        return false;
    }
    @Override
    public boolean canMoveTo(Vector2d position) {
        return !animals.containsKey(position);
    }
    @Override
    public boolean isOccupied(Vector2d position) {
        return objectAt(position) != null;
    }
    @Override
    public String toString() {
        return visualizer.draw(mapBottomLeft, mapTopRight);
    }

    @Override
    public List<WorldElement> getElements(){
        List<WorldElement> elements = new ArrayList<>(animals.values());
        return elements;
    }
}
