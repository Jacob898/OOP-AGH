package agh.ics.oop.model;

public class RectangularMap extends AbstractWorldMap {
    private final int width;
    private final int height;

    public RectangularMap(int width, int height) {
        this.width = width;
        this.height = height;
        this.mapTopRight = new Vector2d(this.width - 1, this.height - 1);
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return position.follows(mapBottomLeft) && position.precedes(mapTopRight) && !isOccupied(position);
    }


}
