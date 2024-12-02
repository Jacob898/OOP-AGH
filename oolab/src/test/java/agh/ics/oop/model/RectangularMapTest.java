package agh.ics.oop.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RectangularMapTest {
    private static final Animal animal1 = new Animal(MapDirection.NORTH,new Vector2d(2,3));
    private static final Animal animal2 = new Animal(MapDirection.EAST,new Vector2d(3,4));
    @Test
    public void ifMapWorks() {
        RectangularMap map = new RectangularMap(5,5);
        try {
            map.place(animal1);
        } catch( IncorrectPositionException e) {
            System.out.println("Warning: " + e.getMessage());
        }
        map.move(animal1,MoveDirection.FORWARD);
        assertEquals(new Vector2d(2,4),animal1.getPosition());
    }

    @Test
    public void canMoveToWithOneAnimal() {
        RectangularMap map = new RectangularMap(5,5);
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
        RectangularMap map = new RectangularMap(5,5);
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
        RectangularMap map = new RectangularMap(4,4);
        try {
            assertTrue(map.place(animal1));
        } catch( IncorrectPositionException e) {
            System.out.println("Warning: " + e.getMessage());
        }

        try {
            assertFalse(map.place(animal2));
        } catch( IncorrectPositionException e) {
            System.out.println("Warning: " + e.getMessage());
        }
    }

    @Test
    public void ifIsOccupiedWorksCorrectly() {
        RectangularMap map = new RectangularMap(5,5);
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
        RectangularMap map = new RectangularMap(5,5);
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
        assertEquals(animal1,map.objectAt(new Vector2d(2,3)));
        assertEquals(animal2,map.objectAt(new Vector2d(3,4)));
    }

    @Test
    public void ifMoveWorksCorrectly() {
        RectangularMap map = new RectangularMap(5,5);
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
        map.move(animal1,MoveDirection.FORWARD);
        map.move(animal2,MoveDirection.FORWARD);
        assertEquals(new Vector2d(2,4),animal1.getPosition());
        assertEquals(new Vector2d(4,4),animal2.getPosition());
    }
    @Test
    public void ifToStringWorksCorrectly() {
        Animal animal3 = new Animal(MapDirection.NORTH,new Vector2d(2,3));
        String expectedMap = " y\\x  0 1 2 3 4\r\n" +
                "  5: -----------\r\n" +
                "  4: | | | | | |\r\n" +
                "  3: | | |N| | |\r\n" +
                "  2: | | | | | |\r\n" +
                "  1: | | | | | |\r\n" +
                "  0: | | | | | |\r\n" +
                " -1: -----------\r\n";
        RectangularMap map = new RectangularMap(5,5);
        try {
            map.place(animal3);
        } catch( IncorrectPositionException e) {
            System.out.println("Warning: " + e.getMessage());
        }
        assertEquals(expectedMap,map.toString());
    }
}