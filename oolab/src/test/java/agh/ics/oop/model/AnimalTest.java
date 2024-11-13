package agh.ics.oop.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class AnimalTest {
    MoveValidator validator = new RectangularMap(5,5);
    @Test
    public void moveAndOrientationOfAnimalWithoutGivenParametersWorksProperly() {
        Animal animal = new Animal();

        animal.move(MoveDirection.FORWARD,validator);
        animal.move(MoveDirection.RIGHT,validator);
        assertTrue(animal.isAt(new Vector2d(2,3)));
        assertEquals(MapDirection.EAST,animal.getDirection());
    }
    @Test
    public void moveAndOrientationOfAnimalWithGivenParametersWorksProperly() {
        Animal animal = new Animal(MapDirection.EAST,new Vector2d(2,3));
        animal.move(MoveDirection.BACKWARD,validator);
        animal.move(MoveDirection.LEFT,validator);
        assertTrue(animal.isAt(new Vector2d(1,3)));
        assertEquals(MapDirection.NORTH,animal.getDirection());
    }
    @Test
    public void animalWithoutGivenParametersDoesntGoOutOfBoundaries() {
        Animal animal = new Animal();
        animal.move(MoveDirection.FORWARD,validator);
        animal.move(MoveDirection.FORWARD,validator);
        animal.move(MoveDirection.FORWARD,validator);
        animal.move(MoveDirection.FORWARD,validator);
        animal.move(MoveDirection.FORWARD,validator);
        assertTrue(animal.isAt(new Vector2d(2,4)));
    }
    @Test
    public void animalWithGivenParametersDoesntGoOutOfBoundaries() {
        Animal animal = new Animal(MapDirection.EAST,new Vector2d(4,4));
        animal.move(MoveDirection.FORWARD,validator);
        animal.move(MoveDirection.FORWARD,validator);
        assertTrue(animal.isAt(new Vector2d(4,4)));
    }

}