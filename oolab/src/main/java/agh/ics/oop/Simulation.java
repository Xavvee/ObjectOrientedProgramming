package agh.ics.oop;

import agh.ics.oop.model.Animal;
import agh.ics.oop.model.MoveDirection;
import agh.ics.oop.model.Vector2d;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Simulation {



    private final List<MoveDirection> moveDirections;
    private final Map<Vector2d, Animal> animals;

    public Simulation(List<Vector2d> startingPositions, List<MoveDirection> moveDirections){
        this.moveDirections = moveDirections;
        Map<Vector2d, Animal> animals = new HashMap<>();
        for(Vector2d position : startingPositions){
            animals.put(position, new Animal(position));
        }
        this.animals = animals;
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

    public Map<Vector2d, Animal> getAnimals() {
        return this.animals;
    }

    public List<MoveDirection> getMoveDirections() {
        return this.moveDirections;
    }
}
