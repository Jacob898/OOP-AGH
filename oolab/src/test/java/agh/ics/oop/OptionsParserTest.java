package agh.ics.oop;

import org.junit.jupiter.api.Test;
import agh.ics.oop.model.MoveDirection;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OptionsParserTest {

    @Test
    void fParsersForward() {
        //given
        String[] args = {"f"};
        List<MoveDirection> expected = List.of(MoveDirection.FORWARD);

        //then
        assertEquals(expected,OptionsParser.parse(args));
    }

    @Test
    void bParsersBackward() {
        //given
        String[] args = {"b"};
        List<MoveDirection> expected = List.of(MoveDirection.BACKWARD);

        //then
        assertEquals(expected,OptionsParser.parse(args));
    }

    @Test
    void rParsersRight() {
        //given
        String[] args = {"r"};
        List<MoveDirection> expected = List.of(MoveDirection.RIGHT);

        //then
        assertEquals(expected,OptionsParser.parse(args));
    }

    @Test
    void lParsersLeft() {
        //given
        String[] args = {"l"};
        List<MoveDirection> expected = List.of(MoveDirection.LEFT);

        //then
        assertEquals(expected,OptionsParser.parse(args));
    }
    @Test
    void emptyThrowsException() {
        //given
        String[] args = {""};
        //then
        assertThrows(IllegalArgumentException.class, () -> OptionsParser.parse(args));
    }
    @Test
    void spaceParsersException() {
        //given
        String[] args = {" "};

        //then
        assertThrows(IllegalArgumentException.class, () -> OptionsParser.parse(args));
    }
    @Test
    void otherThanLRFBThrowsException() {
        //given
        String[] args = {"a"};
        //then
        assertThrows(IllegalArgumentException.class, () -> OptionsParser.parse(args));
    }

    @Test
    void parsersMultipleCorrectAndUncorrectThrowsException()
    {
        //given
        String[] args = {"f","b","h","r","l","6"};
        //then
        assertThrows(IllegalArgumentException.class, () -> OptionsParser.parse(args));
    }

//
}