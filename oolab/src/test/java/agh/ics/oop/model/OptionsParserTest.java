package agh.ics.oop.model;

import agh.ics.oop.OptionsParser;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static agh.ics.oop.OptionsParser.parser;
import static agh.ics.oop.model.MoveDirection.*;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class OptionsParserTest {

    @Test
    public void testOptionsParser(){
        // given
        String[] directions = {"f", "b", "r", "o", "p", "w", "r", "l", "l", "w", "l", "p", "f"};
        // when
        MoveDirection[] convDirections =  parser(directions);
        // then
        MoveDirection[] result = {FORWARD, BACKWARD, RIGHT, RIGHT, LEFT, LEFT, LEFT, FORWARD};
        assertArrayEquals(convDirections, result);
    }
}
