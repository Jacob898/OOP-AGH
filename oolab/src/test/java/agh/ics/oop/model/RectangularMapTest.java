package agh.ics.oop.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RectangularMapTest {
    private static final Vector2d vector1 = new Vector2d(1,1);
    private static final Animal animal1 = new Animal(MapDirection.NORTH,new Vector2d(2,3));
    private static final Animal animal2 = new Animal(MapDirection.EAST,new Vector2d(3,4));
    @Test
    public void ifMapWorks() {
        RectangularMap map = new RectangularMap(5,5);
        map.place(animal1);
        map.move(animal1,MoveDirection.FORWARD);
        assertEquals(new Vector2d(2,4),animal1.getPosition());
    }

    @Test
    public void canMoveToWithOneAnimal() {
        RectangularMap map = new RectangularMap(5,5);
        map.place(animal1);
        assertTrue(map.canMoveTo(new Vector2d(2,4)));
        assertTrue(map.canMoveTo(new Vector2d(1,3)));
    }
    @Test
    public void canMoveToWithTwoAnimals() {
        RectangularMap map = new RectangularMap(5,5);
        map.place(animal1);
        map.place(animal2);
        assertFalse(map.canMoveTo(new Vector2d(3,4)));
    }

    @Test
    public void ifPlaceWorksCorrectly() {
        RectangularMap map = new RectangularMap(4,4);
        assertTrue(map.place(animal1));
        assertFalse(map.place(animal2));
    }

    @Test
    public void ifIsOccupiedWorksCorrectly() {
        RectangularMap map = new RectangularMap(5,5);
        map.place(animal1);
        assertTrue(map.isOccupied(new Vector2d(2,3)));
        assertFalse(map.isOccupied(new Vector2d(0,4)));
    }

    @Test
    public void ifObjectAtWorksCorrectly() {
        RectangularMap map = new RectangularMap(5,5);
        map.place(animal1);
        map.place(animal2);
        assertEquals(animal1,map.objectAt(new Vector2d(2,3)));
        assertEquals(animal2,map.objectAt(new Vector2d(3,4)));
    }

    @Test
    public void ifMoveWorksCorrectly() {
        RectangularMap map = new RectangularMap(5,5);
        map.place(animal1);
        map.place(animal2);
        map.move(animal1,MoveDirection.FORWARD);
        map.move(animal2,MoveDirection.FORWARD);
        assertEquals(new Vector2d(2,4),animal1.getPosition());
        assertEquals(new Vector2d(4,4),animal2.getPosition());
    }
}