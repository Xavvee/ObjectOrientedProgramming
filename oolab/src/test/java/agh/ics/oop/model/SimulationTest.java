package agh.ics.oop.model;

import agh.ics.oop.Simulation;
import org.junit.jupiter.api.Test;

import java.util.List;

import static agh.ics.oop.OptionsParser.parse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SimulationTest {
    @Test
    public void testSimulation(){
        //given
        String[] args = {"f","l","r","f","g","f","p","f","r","t","f","f","t","f","f","t","f","f","t","l","l","f","f","b"};
        List<MoveDirection> directions = parse(args);
        List<Vector2d> positions = List.of(new Vector2d(2,2), new Vector2d(3,4), new Vector2d(0,0));
        Simulation simulation = new Simulation(positions, directions);
        //when
        simulation.run();
        List<Animal> animals = simulation.getAnimals();
        //then

    }
}
