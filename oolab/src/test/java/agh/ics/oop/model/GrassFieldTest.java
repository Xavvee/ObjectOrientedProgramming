package agh.ics.oop.model;

import agh.ics.oop.Simulation;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static agh.ics.oop.model.MoveDirection.*;
import static agh.ics.oop.model.MoveDirection.FORWARD;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GrassFieldTest {

    @Test
    public void testGrassFieldFiveGrasses(){
        //given
        MoveDirection[] moveArray = {FORWARD,RIGHT,LEFT,FORWARD,FORWARD,FORWARD,RIGHT,FORWARD,FORWARD,FORWARD,FORWARD,RIGHT,LEFT,FORWARD,FORWARD,LEFT,FORWARD};
        List<MoveDirection> directions = Arrays.asList(moveArray);
        List<Vector2d> positions = List.of(new Vector2d(4,1), new Vector2d(1,2));
        WorldMap map = new GrassField(5);
        Simulation simulation = new Simulation(positions, directions, map);
        //when
        simulation.run();
        List<Animal> animals = simulation.getAnimals();
        //then
        assertTrue(animals.get(0).isAt(new Vector2d(1,4)));
        assertTrue(animals.get(1).isAt(new Vector2d(3,1)));
        assertEquals(animals.get(0).getDirection(),MapDirection.WEST);
        assertEquals(animals.get(1).getDirection(),MapDirection.EAST);
    }

    @Test
    public void testGrassFieldTenGrasses(){
        //given
        MoveDirection[] moveArray = {FORWARD,RIGHT,LEFT,FORWARD,FORWARD,FORWARD,RIGHT,FORWARD,FORWARD,FORWARD,FORWARD,RIGHT,LEFT,FORWARD,FORWARD,LEFT,FORWARD};
        List<MoveDirection> directions = Arrays.asList(moveArray);
        List<Vector2d> positions = List.of(new Vector2d(4,1), new Vector2d(1,2));
        WorldMap map = new GrassField(10);
        Simulation simulation = new Simulation(positions, directions, map);
        //when
        simulation.run();
        List<Animal> animals = simulation.getAnimals();
        //then
        assertTrue(animals.get(0).isAt(new Vector2d(1,4)));
        assertTrue(animals.get(1).isAt(new Vector2d(3,1)));
        assertEquals(animals.get(0).getDirection(),MapDirection.WEST);
        assertEquals(animals.get(1).getDirection(),MapDirection.EAST);
    }

    @Test
    public void testGrassFieldFifteenGrasses(){
        //given
        MoveDirection[] moveArray = {FORWARD,RIGHT,LEFT,FORWARD,FORWARD,FORWARD,RIGHT,FORWARD,FORWARD,FORWARD,FORWARD,RIGHT,LEFT,FORWARD,FORWARD,LEFT,FORWARD};
        List<MoveDirection> directions = Arrays.asList(moveArray);
        List<Vector2d> positions = List.of(new Vector2d(4,1), new Vector2d(1,2));
        WorldMap map = new GrassField(15);
        Simulation simulation = new Simulation(positions, directions, map);
        //when
        simulation.run();
        List<Animal> animals = simulation.getAnimals();
        //then
        assertTrue(animals.get(0).isAt(new Vector2d(1,4)));
        assertTrue(animals.get(1).isAt(new Vector2d(3,1)));
        assertEquals(animals.get(0).getDirection(),MapDirection.WEST);
        assertEquals(animals.get(1).getDirection(),MapDirection.EAST);
    }
}
