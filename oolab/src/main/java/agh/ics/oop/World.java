package agh.ics.oop;

import agh.ics.oop.model.*;

import java.util.List;

import static agh.ics.oop.OptionsParser.parse;

public class World {
    public static void main(String[] args){
        List<MoveDirection> directions = parse(args);
        List<Vector2d> positions1 = List.of(new Vector2d(0,0), new Vector2d(0,2), new Vector2d(3,6), new Vector2d(1,0));
        List<Vector2d> positions2 = List.of(new Vector2d(4,5), new Vector2d(1,5), new Vector2d(2,2), new Vector2d(5,0));
        WorldMap map1 = new GrassField(4);
        WorldMap map2 = new RectangularMap(10,10);
        Simulation simulation1 = new Simulation(positions1, directions, map1);
        Simulation simulation2 = new Simulation(positions2, directions, map2);
        List<Simulation> simulations = List.of(simulation1, simulation2);
        SimulationEngine engine = new SimulationEngine(simulations);
        engine.runSync();
    }


    static void run(MoveDirection[] directions){
        for (MoveDirection dir : directions) {
            switch (dir){
                case FORWARD -> System.out.println("Zwierzak idzie do przodu.");
                case BACKWARD -> System.out.println("Zwierzak idzie do tyłu.");
                case RIGHT -> System.out.println("Zwierzak skręca w prawo.");
                case LEFT -> System.out.println("Zwierzak skręca w lewo.");
                default -> {
                }
            }
        }
    }
}

