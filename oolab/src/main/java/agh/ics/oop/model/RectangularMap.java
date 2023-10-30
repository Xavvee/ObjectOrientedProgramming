package agh.ics.oop.model;

import java.util.HashMap;
import java.util.Map;

public class RectangularMap implements WorldMap {
    private final int height;
    private final int width;

    private Map<Vector2d, Animal> animals;

    public RectangularMap(int height, int width){
        this.height = height;
        this.width = width;
        this.animals = new HashMap<>();
    }


    @Override
    public boolean canMoveTo(Vector2d position) {
        return false;
    }

    @Override
    public boolean place(Animal animal) {
        return false;
    }

    @Override
    public void move(Animal animal, MoveDirection direction) {

    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return false;
    }

    @Override
    public Animal objectAt(Vector2d position) {
        return null;
    }
}
