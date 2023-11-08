package agh.ics.oop.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class GrassField extends AbstractWorldMap {

    private final int numberOfGrasses;

    private static final int HEIGHT = Integer.MAX_VALUE;
    private static final int WIDTH = Integer.MAX_VALUE;
    private Map<Vector2d, Grass> grasses;


    public GrassField(int numberOfGrasses){
        this.numberOfGrasses = numberOfGrasses;
        this.grasses = new HashMap<>();
        this.animals = new HashMap<>();
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
        if(this.isOccupied(randomPosition)){
            return false;
        }
        grasses.put(randomPosition, new Grass(randomPosition));
        return true;
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return super.canMoveTo(position) && (!isOccupied(position) || !(objectAt(position) instanceof Animal));
    }


    @Override
    public WorldElement objectAt(Vector2d position) {
        if(super.objectAt(position) != null){
            return super.objectAt(position);
        }
        return grasses.get(position);
    }

    public Vector2d getUpperRight(){
        return new Vector2d(WIDTH, HEIGHT);
    }

    public Vector2d getLowerLeft(){
        return new Vector2d(-WIDTH, -HEIGHT);
    }


    public Vector2d calculateLowerLeft(){
        Vector2d lowerLeft = new Vector2d(WIDTH, HEIGHT);
        for(Grass grass : grasses.values()){
            lowerLeft = grass.getPosition().lowerLeft(lowerLeft);
        }
        for(Animal animal : animals.values()){
            lowerLeft = animal.getPosition().lowerLeft(lowerLeft);
        }
        return lowerLeft;
    }

    public Vector2d calculateUpperRight(){
        Vector2d upperRight = new Vector2d(-WIDTH, -HEIGHT);
        for(Grass grass : grasses.values()){
            upperRight = grass.getPosition().upperRight(upperRight);
        }
        for(Animal animal : animals.values()){
            upperRight = animal.getPosition().upperRight(upperRight);
        }
        return upperRight;
    }

    @Override
    protected Vector2d getRightBound() {
        return calculateUpperRight();
    }

    @Override
    protected Vector2d getLeftBound() {
        return calculateLowerLeft();
    }
}
