package agh.ics.oop;

import agh.ics.oop.model.Animal;
import agh.ics.oop.model.MoveDirection;
import agh.ics.oop.model.Vector2d;
import agh.ics.oop.model.WorldMap;

import java.util.ArrayList;
import java.util.List;

public class Simulation {


    private final List<MoveDirection> moveDirections;
    private final List<Animal> animals;
    private final WorldMap map;

    public Simulation(List<Vector2d> startingPositions, List<MoveDirection> moveDirections, WorldMap map){
        this.moveDirections = moveDirections;
        this.map = map;
        List<Animal> animals = new ArrayList<>();
        for(Vector2d position : startingPositions){
            Animal animal = new Animal(position);
            try {
                if(map.place(animal)) {
                    animals.add(animal);
                }
            } catch (PositionAlreadyOccupied e) {
                System.out.println("Position at " + position.toString() + " is already occupied. Animal placement skipped.");
            }
        }
        this.animals = animals;
    }

    public void run(){
        int numberOfAnimals = animals.size();
        int iter = 0;
        for( MoveDirection direction : moveDirections){
            int index = iter%numberOfAnimals;
            map.move( animals.get(index), direction);
            iter++;
            try {
                Thread.sleep(500); // Pauza między ruchami
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public List<Animal> getAnimals() {
        return this.animals;
    }

    public List<MoveDirection> getMoveDirections() {
        return this.moveDirections;
    }
}
