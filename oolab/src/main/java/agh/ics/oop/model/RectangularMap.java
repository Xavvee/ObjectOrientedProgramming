package agh.ics.oop.model;

import java.util.HashMap;
import java.util.Map;

public class RectangularMap implements WorldMap {
    private final int height;
    private final int width;

    public RectangularMap(int height, int width){
        this.height = height;
        this.width = width;
    }


    @Override
    public boolean canMoveTo(Vector2d position) {
        Vector2d upperRightCorner = new Vector2d(width, height);
        return position.follows(upperRightCorner) && (new Vector2d(0,0)).precedes(position);
    }

    @Override
    public boolean place(Animal animal) {
        if()
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
        if(this.isOccupied(position)){
            return animals.get(position);
        }
        return null;
    }
}
