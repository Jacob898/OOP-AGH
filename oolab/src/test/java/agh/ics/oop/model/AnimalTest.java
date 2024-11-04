package agh.ics.oop.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class AnimalTest {
    @Test
    public void moveAndOrientationOfAnimalWithoutGivenParametersWorksProperly() {
        Animal animal = new Animal();
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.RIGHT);
        assertTrue(animal.isAt(new Vector2d(2,3)));
        assertEquals(MapDirection.EAST,animal.getDirection());
    }
    @Test
    public void moveAndOrientationOfAnimalWithGivenParametersWorksProperly() {
        Animal animal = new Animal(MapDirection.EAST,new Vector2d(2,3));
        animal.move(MoveDirection.BACKWARD);
        animal.move(MoveDirection.LEFT);
        assertTrue(animal.isAt(new Vector2d(1,3)));
        assertEquals(MapDirection.NORTH,animal.getDirection());
    }
    @Test
    public void animalWithoutGivenParametersDoesntGoOutOfBoundaries() {
        Animal animal = new Animal();
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.FORWARD);
        assertTrue(animal.isAt(new Vector2d(2,4)));
    }
    @Test
    public void animalWithGivenParametersDoesntGoOutOfBoundaries() {
        Animal animal = new Animal(MapDirection.EAST,new Vector2d(4,4));
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.FORWARD);
        assertTrue(animal.isAt(new Vector2d(4,4)));
    }


}