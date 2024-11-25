package agh.ics.oop.model;

import agh.ics.oop.model.util.MapVisualizer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GrassField extends AbstractWorldMap {
    private final int grassFieldsAmount;
    private final Map<Vector2d,Grass> grass = new HashMap<>();

    public GrassField(int grassFieldsAmount) {
        this.grassFieldsAmount = grassFieldsAmount;
//        generatePositions();
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

//    public void generatePositions() {
//        int mapSizeX= (int) Math.sqrt((double)grassFieldsAmount * 10) ;
//        int mapSizeY = mapSizeX;
//        int cnt = 0;
//        while (cnt < grassFieldsAmount) {
//            int x = (int) ((Math.random() * mapSizeX));
//            int y = (int) ((Math.random() * mapSizeY));
//            Vector2d grassField = new Vector2d(x, y);
//            calculateMapSize(grassField);
//            grass.put(grassField, new Grass(grassField));
//            cnt++;
//        }
//    }

    @Override
    public void move(Animal animal, MoveDirection direction) {
        Vector2d position = animal.getPosition();
        animal.move(direction, this);
            if (!position.equals(animal.getPosition())){
                animals.put(animal.getPosition(), animal);
                animals.remove(position);
                int x = animal.getPosition().getX();
                int y = animal.getPosition().getY();
                Vector2d vec = new Vector2d(x, y);
                calculateMapSize(vec);
            }

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
