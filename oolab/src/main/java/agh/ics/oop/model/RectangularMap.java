package agh.ics.oop.model;

import agh.ics.oop.MapVisualizer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RectangularMap implements WorldMap {
    private final int height;
    private final int width;
    private Map<Vector2d, Animal> animals;
    private final MapVisualizer visualizer = new MapVisualizer(this);

    public RectangularMap(int height, int width){
        this.height = height;
        this.width = width;
        this.animals = new HashMap<>();
    }


    @Override
    public boolean canMoveTo(Vector2d position) {
        return position.precedes(this.getUpperRight()) && (this.getLowerLeft().precedes(position) && !isOccupied(position));
    }

    @Override
    public boolean place(Animal animal) {
        if(canMoveTo(animal.getPosition())){
            animals.put(animal.getPosition(), animal);
            return true;
        }
        return false;
    }

    @Override
    public void move(Animal animal, MoveDirection direction) {
        if(animals.containsKey(animal.getPosition())){
            Vector2d oldPosition = animal.getPosition();
            animal.move(direction, this);
            Vector2d newPosition = animal.getPosition();
            if (canMoveTo(newPosition)) {
                animals.remove(oldPosition);
                animals.put(newPosition, animal);
            }
        }
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return objectAt(position) instanceof Animal;
    }

    @Override
    public WorldElement objectAt(Vector2d position) {
        return animals.get(position);
    }

    public Vector2d getLowerLeft(){
        return new Vector2d(0,0);
    }

    public Vector2d getUpperRight(){
        return new Vector2d(width, height);
    }
    @Override
    public String toString(){
        return visualizer.draw(this.getLowerLeft(), this.getUpperRight());
    }
}
