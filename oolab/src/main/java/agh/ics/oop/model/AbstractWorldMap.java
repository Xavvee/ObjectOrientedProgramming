package agh.ics.oop.model;

import agh.ics.oop.Comparator;
import agh.ics.oop.MapVisualizer;
import agh.ics.oop.PositionAlreadyOccupied;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public abstract class AbstractWorldMap implements WorldMap {
    protected Map<Vector2d, Animal> animals = new HashMap<>();
    protected final MapVisualizer visualizer = new MapVisualizer(this);

    protected Comparator XComparator = new Comparator(true);

    protected Comparator YComparator = new Comparator(false);
    protected TreeSet<Vector2d> sortedX = new TreeSet<>(XComparator);
    protected TreeSet<Vector2d> sortedY = new TreeSet<>(YComparator);


    @Override
    public boolean canMoveTo(Vector2d position) {
        return position.precedes(this.getUpperRight()) && (this.getLowerLeft().precedes(position));
    }


    @Override
    public boolean place(Animal animal) throws PositionAlreadyOccupied {
        if(canMoveTo(animal.getPosition())){
            animals.put(animal.getPosition(), animal);
            addElements(animal.getPosition());
            return true;
        } else {
            throw new PositionAlreadyOccupied(animal.getPosition());
        }
    }

    @Override
    public void move(Animal animal, MoveDirection direction) {
        if(animals.containsKey(animal.getPosition())){
            Vector2d oldPosition = animal.getPosition();
            animal.move(direction, this);
            Vector2d newPosition = animal.getPosition();
            if (canMoveTo(newPosition)) {
                animals.remove(oldPosition);
                removeElement(oldPosition);
                animals.put(newPosition, animal);
                addElements(newPosition);
            }
        }
    }

    protected void addElements(Vector2d element){
        sortedX.add(element);
        sortedY.add(element);
    }


    protected void removeElement(Vector2d element){
        sortedY.remove(element);
        sortedX.remove(element);
    }


    @Override
    public boolean isOccupied(Vector2d position) {
        return objectAt(position) != null;
    }

    @Override
    public WorldElement objectAt(Vector2d position) {
        return animals.get(position);
    }

    @Override
    public String toString(){
        return visualizer.draw(getLeftBound(),getRightBound());
    }

    @Override
    public Map<Vector2d, WorldElement> getElements() {
        Map<Vector2d, WorldElement> allElements = new HashMap<>(animals);
        return allElements;
    }

    protected abstract Vector2d getLeftBound();

    protected abstract Vector2d getRightBound();

    protected abstract Vector2d getUpperRight();
    protected abstract Vector2d getLowerLeft();



}
