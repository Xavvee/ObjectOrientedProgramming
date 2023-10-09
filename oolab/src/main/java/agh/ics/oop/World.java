package agh.ics.oop;

import agh.ics.oop.model.MoveDirection;

public class World {
    public static void main(String[] args){
        System.out.println("System wystartował.");
        MoveDirection[] directions = new OptionsParser(args);
        run(args);
        System.out.println("System zakończył działanie.");
    }

    static void run(String[] args){
        for (String arg : args) {
            switch (arg){
                case "f" -> System.out.println("Zwierzak idzie do przodu.");
                case "b" -> System.out.println("Zwierzak idzie do tyłu.");
                case "r" -> System.out.println("Zwierzak skręca w prawo.");
                case "l" -> System.out.println("Zwierzak skręca w lewo.");
                default -> {
                }
            }
        }
    }
}

