package agh.ics.oop;

import org.junit.jupiter.api.Test;
import agh.ics.oop.model.MoveDirection;
import static org.junit.jupiter.api.Assertions.*;

class OptionsParserTest {
    @Test
    void fParsersForward() {
        //given
        String[] args = {"f"};
        MoveDirection[] expected = {MoveDirection.FORWARD};

        //then
        assertArrayEquals(expected,OptionsParser.parser(args));
    }

    @Test
    void bParsersBackward() {
        //given
        String[] args = {"b"};
        MoveDirection[] expected = {MoveDirection.BACKWARD};

        //then
        assertArrayEquals(expected,OptionsParser.parser(args));
    }

    @Test
    void rParsersRight() {
        //given
        String[] args = {"r"};
        MoveDirection[] expected = {MoveDirection.RIGHT};

        //then
        assertArrayEquals(expected,OptionsParser.parser(args));
    }

    @Test
    void lParsersLeft() {
        //given
        String[] args = {"l"};
        MoveDirection[] expected = {MoveDirection.LEFT};

        //then
        assertArrayEquals(expected,OptionsParser.parser(args));
    }
    @Test
    void emptyParsersNothing() {
        //given
        String[] args = {""};
        MoveDirection[] expected = {};
        //then
        assertArrayEquals(expected,OptionsParser.parser(args));
    }
    @Test
    void spaceParsersNothing() {
        //given
        String[] args = {" "};
        MoveDirection[] expected = {};
        //then
        assertArrayEquals(expected,OptionsParser.parser(args));
    }
    @Test
    void otherThanLRFBParserNothing() {
        //given
        String[] args = {"a"};
        MoveDirection[] expected = { };
        //then
        assertArrayEquals(expected,OptionsParser.parser(args));
    }

    @Test
    void parsersMultipleCorrectAndUncorrectDirections()
    {
        //given
        String[] args = {"f","b","h","r","l","6"};
        MoveDirection[] expected = {MoveDirection.FORWARD, MoveDirection.BACKWARD,MoveDirection.RIGHT,MoveDirection.LEFT};
        //then
        assertArrayEquals(expected,OptionsParser.parser(args));
    }


}