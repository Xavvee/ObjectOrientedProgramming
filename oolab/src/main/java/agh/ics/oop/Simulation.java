package agh.ics.oop;

import agh.ics.oop.model.Animal;
import agh.ics.oop.model.MoveDirection;
import agh.ics.oop.model.Vector2d;

import java.util.ArrayList;
import java.util.List;

public class Simulation {



    private final List<MoveDirection> moveDirections;
    private final List<Animal> animals;

    public Simulation(List<Vector2d> startingPositions, List<MoveDirection> moveDirections){
        this.moveDirections = moveDirections;
        List<Animal> animalsCreate = new ArrayList<>();
        for(Vector2d position : startingPositions){
            animalsCreate.add(new Animal(position));
        }
        this.animals = animalsCreate;
    }

    public void run(){
        int numberOfAnimals = animals.size();
        int iter = 0;
        for( MoveDirection direction : moveDirections){
            int index = iter%numberOfAnimals;
            animals.get(index).move(direction);
            System.out.println("Zwierzę " + index + ": " + animals.get(index));
            iter++;
        }
    }

    public List<Animal> getAnimals() {
        return this.animals;
    }

    public List<MoveDirection> getMoveDirections() {
        return this.moveDirections;
    }
}
