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
    void emptyParsersNothing() {
        //given
        String[] args = {""};
        List<MoveDirection> expected = List.of();
        //then
        assertEquals(expected,OptionsParser.parse(args));
    }
    @Test
    void spaceParsersNothing() {
        //given
        String[] args = {" "};
        List<MoveDirection> expected = List.of();
        //then
        assertEquals(expected,OptionsParser.parse(args));
    }
    @Test
    void otherThanLRFBParserNothing() {
        //given
        String[] args = {"a"};
        List<MoveDirection> expected = List.of();
        //then
        assertEquals(expected,OptionsParser.parse(args));
    }

    @Test
    void parsersMultipleCorrectAndUncorrectDirections()
    {
        //given
        String[] args = {"f","b","h","r","l","6"};
        List<MoveDirection> expected = List.of(MoveDirection.FORWARD, MoveDirection.BACKWARD,MoveDirection.RIGHT,MoveDirection.LEFT);
        //then
        assertEquals(expected,OptionsParser.parse(args));
    }

//
}