package agh.ics.oop.model;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class GrassFieldTest {

    private static final Animal animal1 = new Animal(MapDirection.NORTH,new Vector2d(2,3));
    private static final Animal animal2 = new Animal(MapDirection.EAST,new Vector2d(3,4));

    @Test
    public void canMoveToWithOneAnimal() {
        GrassField map = new GrassField(10);
        map.place(animal1);
        assertTrue(map.canMoveTo(new Vector2d(2,4)));
        assertTrue(map.canMoveTo(new Vector2d(1,3)));
    }

    @Test
    public void canMoveToWithTwoAnimals() {
        GrassField map = new GrassField(10);
        map.place(animal1);
        map.place(animal2);
        assertFalse(map.canMoveTo(new Vector2d(3,4)));
    }

    @Test
    public void ifPlaceWorksCorrectly() {

        GrassField map = new GrassField(10);
        Map<Vector2d,Animal> testMap = map.getAnimals();
        map.place(animal1);
        map.place(animal2);
        assertTrue(testMap.containsKey(new Vector2d(2,3)));
        assertTrue(testMap.containsKey(new Vector2d(3,4)));

    }

    @Test
    public void ifIsOccupiedWorksCorrectly() {
        GrassField map = new GrassField(10);
        map.place(animal1);
        assertTrue(map.isOccupied(new Vector2d(2,3)));
        assertFalse(map.isOccupied(new Vector2d(0,4)));
    }

    @Test
    public void ifObjectAtWorksCorrectly() {
        GrassField map = new GrassField(10) ;
        map.place(animal1);
        map.place(animal2);
        assertEquals(animal1, map.objectAt(new Vector2d(2,3)));
        assertEquals(animal2, map.objectAt(new Vector2d(3,4)));
    }

    @Test
    public void ifMoveWorksCorrectly() {
        GrassField map = new GrassField(10);
        map.place(animal1);
        map.place(animal2);
        map.move(animal1,MoveDirection.FORWARD);
        map.move(animal2,MoveDirection.FORWARD);
        assertEquals(new Vector2d(2,4),animal1.getPosition());
        assertEquals(new Vector2d(4,4),animal2.getPosition());
    }


}