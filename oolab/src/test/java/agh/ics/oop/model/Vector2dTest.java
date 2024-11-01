package agh.ics.oop.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Vector2dTest {
    Vector2d v1 = new Vector2d(1,2);
    Vector2d v2 = new Vector2d(-1,1);
    Vector2d v3 = new Vector2d(2,0);

    @Test
    void doesEqualsWork() {
        assertFalse(v1.equals(v2));
        assertFalse(v1.equals("test"));
        assertTrue(v1.equals(v1));
    }

    @Test
    void toStringWorks() {
        assertEquals(("(1,2)"),v1.toString());
    }

    @Test
    void precedes() {
        assertTrue(v2.precedes(v1));
    }

    @Test
    void follows() {
        assertTrue(v1.follows(v2));
    }

    @Test
    void upperRight() {
        assertEquals(new Vector2d(1,3), v1.upperRight(new Vector2d(-1,3))); //v1 first, new Vector2d second
        assertEquals(new Vector2d(5,5), v3.upperRight(new Vector2d(5,5)) ); // v3 none, new Vector2d both
        assertEquals(new Vector2d(3,2), v1.upperRight(new Vector2d(3,-1)) ); // v1 second, new Vector2d first
        assertNotEquals(new Vector2d(-1,0), v3.upperRight(v2) ); // v3 none, v2 none
    }

    @Test
    void lowerLeft() {
        assertEquals(new Vector2d(1,0), v1.lowerLeft(v3) ); //v1 first, v3 second
        assertEquals(new Vector2d(-1,1), v2.lowerLeft(v1) ); // v2 both, v1 none
        assertEquals(new Vector2d(-1,0), v3.lowerLeft(v2) ); // v3 second, v2 first
        assertNotEquals(new Vector2d(2,2), v1.lowerLeft(v3) ); // v1 none, v3 none
    }

    @Test
    void add() {
        assertEquals(new Vector2d(0,3), v1.add(v2));
    }

    @Test
    void subtract() {
        assertEquals(new Vector2d(1,-2), v3.subtract(v1));
    }

    @Test
    void opposite() {
        assertEquals(new Vector2d(-1,-2),v1.opposite());
    }
}