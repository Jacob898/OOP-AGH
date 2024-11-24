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
        try {
            map.place(animal1);
        } catch( IncorrectPositionException e) {
            System.out.println("Warning: " + e.getMessage());
        }

        assertTrue(map.canMoveTo(new Vector2d(2,4)));
        assertTrue(map.canMoveTo(new Vector2d(1,3)));
    }

    @Test
    public void canMoveToWithTwoAnimals() {
        GrassField map = new GrassField(10);
        try {
            map.place(animal1);
        } catch( IncorrectPositionException e) {
            System.out.println("Warning: " + e.getMessage());
        }
        try {
            map.place(animal2);
        } catch( IncorrectPositionException e) {
            System.out.println("Warning: " + e.getMessage());
        }
        assertFalse(map.canMoveTo(new Vector2d(3,4)));
    }

    @Test
    public void ifPlaceWorksCorrectly() {

        GrassField map = new GrassField(10);
        Map<Vector2d,Animal> testMap = map.getAnimals();
        try {
            map.place(animal1);
        } catch( IncorrectPositionException e) {
            System.out.println("Warning: " + e.getMessage());
        }
        assertTrue(testMap.containsKey(new Vector2d(2,3)));

    }

    @Test
    public void ifIsOccupiedWorksCorrectly() {
        GrassField map = new GrassField(10);
        try {
            map.place(animal1);
        } catch( IncorrectPositionException e) {
            System.out.println("Warning: " + e.getMessage());
        }
        assertTrue(map.isOccupied(new Vector2d(2,3)));
        assertFalse(map.isOccupied(new Vector2d(0,4)));
    }

    @Test
    public void ifObjectAtWorksCorrectly() {
        GrassField map = new GrassField(10) ;
        try {
            map.place(animal1);
        } catch( IncorrectPositionException e) {
            System.out.println("Warning: " + e.getMessage());
        }
        assertEquals(animal1, map.objectAt(new Vector2d(2,3)));
    }

    @Test
    public void ifMoveWorksCorrectly() {
        GrassField map = new GrassField(10);
        try {
            map.place(animal1);
        } catch( IncorrectPositionException e) {
            System.out.println("Warning: " + e.getMessage());
        }
        map.move(animal1,MoveDirection.FORWARD);
        assertEquals(new Vector2d(2,4),animal1.getPosition());
    }


}