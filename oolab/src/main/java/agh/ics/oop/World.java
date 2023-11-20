package agh.ics.oop;

import agh.ics.oop.model.*;

import java.util.List;

import static agh.ics.oop.OptionsParser.parse;

public class World {
    public static void main(String[] args){
//        List<MoveDirection> directions = parse(args);
//        List<Vector2d> positions = List.of(new Vector2d(2,2), new Vector2d(2,2));
//        WorldMap map = new RectangularMap(4,4);
//        Simulation simulation = new Simulation(positions, directions, map);
//        simulation.run();
        List<MoveDirection> directions = parse(args);
        List<Vector2d> positions = List.of(new Vector2d(0,0), new Vector2d(0,0), new Vector2d(0,0), new Vector2d(1,0));
        WorldMap map = new GrassField(4);
        Simulation simulation = new Simulation(positions, directions, map);
        simulation.run();
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

