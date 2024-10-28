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
        assertEquals(new Vector2d(2,2), v1.upperRight(v3) );
    }

    @Test
    void lowerLeft() {
        assertEquals(new Vector2d(1,0), v1.lowerLeft(v3) );
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