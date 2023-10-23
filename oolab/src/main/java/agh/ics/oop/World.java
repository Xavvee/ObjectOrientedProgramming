package agh.ics.oop;

import agh.ics.oop.model.MoveDirection;

public class World {
    public static void main(String[] args){
        Vector2d position1 = new Vector2d(1,2);
        System.out.println(position1);
        Vector2d position2 = new Vector2d(-2,1);
        System.out.println(position2);
        System.out.println(position1.add(position2));
        MapDirection direction =  MapDirection.EAST;
        System.out.println(direction);
        System.out.println(direction.next());
        System.out.println(direction.previous());
        System.out.println(direction.toUnitVector());
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

