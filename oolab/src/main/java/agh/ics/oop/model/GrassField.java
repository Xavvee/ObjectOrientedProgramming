package agh.ics.oop.model;

import java.util.Map;
import java.util.Random;

public class GrassField implements WorldMap {

    private final int numberOfGrasses;

    private final int height = Integer.MAX_VALUE;
    private final int width = Integer.MAX_VALUE;
    private Map<Vector2d, Animal> animals;
    private Map<Vector2d, Grass> grasses;

    public GrassField(int numberOfGrasses){
        this.numberOfGrasses = numberOfGrasses;
        Random rand = new Random();
        for ( int i = 0; i < numberOfGrasses; i++){
            while (true){
                if(generateGrass(rand)){
                    break;
                }
            }
        }

    }   

    private boolean generateGrass(Random rand){
        Vector2d randomPosition = new Vector2d(rand.nextInt((int) Math.sqrt(numberOfGrasses*10)), rand.nextInt((int) Math.sqrt(numberOfGrasses*10)));
        if(grasses.containsValue(randomPosition)){
            return false;
        }
        grasses.put(randomPosition, new Grass(randomPosition));
        return true;
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
    public Animal objectAt(Vector2d position) {
        return animals.get(position);
    }

    public Vector2d getUpperRight(){
        return new Vector2d(width, height);
    }

    public Vector2d getLowerLeft(){
        return new Vector2d(-width, -height);
    }
}
