package agh.ics.oop;

import agh.ics.oop.model.MoveDirection;

import static agh.ics.oop.OptionsParser.OptionsParser;

public class World {
    public static void main(String[] args){
        System.out.println("System wystartował.");
        run(OptionsParser(args));
        System.out.println("System zakończył działanie.");
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

