package agh.ics.oop.model;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static agh.ics.oop.OptionsParser.parser;
import static agh.ics.oop.model.MoveDirection.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class OptionsParserTest {

    @Test
    public void testOptionsParser(){
        // given
        String[] directions = {"f", "b", "r", "o", "p", "w", "r", "l", "l", "w", "l", "p", "f"};
        // when
        List<MoveDirection> convDirections =  parser(directions);
        // then
        MoveDirection[] moveArray = {FORWARD, BACKWARD, RIGHT, RIGHT, LEFT, LEFT, LEFT, FORWARD};
        List<MoveDirection> result = Arrays.asList(moveArray);
        assertEquals(convDirections, result);
    }
}
