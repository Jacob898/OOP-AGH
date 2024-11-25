package agh.ics.oop.model;

import java.util.*;

public class RandomPositionGenerator implements Iterable<Vector2d> {
    private final int maxWidth;
    private final int maxHeight;
    private final int grassFieldsAmount;
    private final List<Vector2d> allPositions;

    public RandomPositionGenerator(int maxWidth, int maxHeight, int grassFieldsAmount) {
        this.maxWidth = maxWidth;
        this.maxHeight = maxHeight;
        this.grassFieldsAmount = grassFieldsAmount;
        this.allPositions = generateAllPositions();
        Collections.shuffle(allPositions);
    }

    public List<Vector2d> generateAllPositions() {
        List<Vector2d> positions = new ArrayList<>();
        for (int x=0; x < maxWidth; x++) {
            for (int y=0; y < maxHeight; y++) {
                positions.add(new Vector2d(x, y));
            }
        }
        return positions;
    }

    @Override
    public Iterator<Vector2d> iterator() {
        return new Iterator<Vector2d>() {
            private int numberOfGeneratedItems = 0;
            @Override
            public boolean hasNext() {
                return numberOfGeneratedItems < grassFieldsAmount;
            }

            @Override
            public Vector2d next() {
                Collections.shuffle(allPositions);
                Vector2d position = allPositions.get(0);
                numberOfGeneratedItems++;
               allPositions.remove(0);

                return position;

            }
        };
    }
}
