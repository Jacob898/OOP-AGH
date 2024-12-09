package agh.ics.oop.model;

import agh.ics.oop.model.util.MapVisualizer;

import java.util.*;

public abstract class AbstractWorldMap implements WorldMap {
    protected final int id = this.hashCode();
    protected Map<Vector2d,Animal> animals = new HashMap<>();
    protected MapVisualizer visualizer = new MapVisualizer(this);
    protected Vector2d mapBottomLeft = new Vector2d(0, 0);
    protected Vector2d mapTopRight = new Vector2d(0, 0);

    protected ArrayList<MapChangeListener> observers = new ArrayList<>();

    public void addObserver(MapChangeListener observer) {
        observers.add(observer);
    }

    public void removeObserver(MapChangeListener observer) {
        observers.remove(observer);
    }

    public void notifyObservers(String message) {
        for (MapChangeListener observer : observers) {
            observer.mapChanged(this, message);
        }
    }

    @Override
    public void move(Animal animal, MoveDirection direction) {
        Vector2d position = animal.getPosition();
        animal.move(direction, this);
        animals.remove(position, animal);
        animals.put(animal.getPosition(), animal);
        notifyObservers("Animal moved from " + position + " to " + animal.getPosition());
    }

    @Override
    public WorldElement objectAt(Vector2d position) {
        return animals.get(position);
    }

    @Override
    public boolean place(Animal animal) throws IncorrectPositionException {
        if(canMoveTo(animal.getPosition())) {
            animals.put(animal.getPosition(), animal);
            notifyObservers("Animal placed at " + animal.getPosition());
            return true;
        }
        throw new IncorrectPositionException(animal.getPosition());
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
        return visualizer.draw(getCurrentBounds().mapBottomLeft(), getCurrentBounds().mapTopRight());
    }

    @Override
    public List<WorldElement> getElements(){
        List<WorldElement> elements = new ArrayList<>(animals.values());
        return elements;
    }

    @Override
    public Boundary getCurrentBounds(){
        return new Boundary(mapBottomLeft, mapTopRight);
    }

    @Override
    public int getId(){
        return id;
    }

}
