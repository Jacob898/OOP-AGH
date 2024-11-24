package agh.ics.oop.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GrassField extends AbstractWorldMap {
    private final int grassFieldsAmount;
    private final Map<Vector2d,Grass> grass = new HashMap<>();

    public GrassField(int grassFieldsAmount) {
        this.grassFieldsAmount = grassFieldsAmount;
        int maxWidth=(int) Math.sqrt((double)grassFieldsAmount * 10);
        int maxHeight = maxWidth;

        RandomPositionGenerator randomPositionGenerator = new RandomPositionGenerator(maxWidth, maxHeight, grassFieldsAmount);
        for(Vector2d grassPosition : randomPositionGenerator) {
            grass.put(grassPosition, new Grass(grassPosition));
            calculateMapSize(grassPosition);
        }
    }

    public void calculateMapSize(Vector2d position) {
        mapBottomLeft = mapBottomLeft.lowerLeft(position);
        mapTopRight = mapTopRight.upperRight(position);
    }


    @Override
    public void move(Animal animal, MoveDirection direction) {
        Vector2d position = animal.getPosition();
        animal.move(direction, this);
        animals.remove(position);
        animals.put(animal.getPosition(), animal);
        notifyObservers("Animal moved from " + position + " to " + animal.getPosition());

        int x = animal.getPosition().getX();
        int y = animal.getPosition().getY();
        Vector2d newPosition = new Vector2d(x, y);
        calculateMapSize(newPosition);

    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return (super.isOccupied(position) || grass.containsKey(position));
    }

    @Override
    public WorldElement objectAt(Vector2d position) {
        if (super.objectAt(position) != null) {
            return super.objectAt(position);
        }
        return grass.get(position);
    }

    @Override
    public List<WorldElement> getElements() {
        List<WorldElement> elements = super.getElements();
        elements.addAll(grass.values());
        return elements;
    }
    //getter
    public Map<Vector2d,Grass> getGrass() {
        return grass;
    }

    public Map<Vector2d,Animal> getAnimals() {
        return animals;
    }
}
