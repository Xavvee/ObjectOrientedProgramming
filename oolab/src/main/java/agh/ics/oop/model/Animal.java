package agh.ics.oop.model;

public class Animal {

    private final Vector2d lowerBound = new Vector2d(0,0);
    private final Vector2d upperBound = new Vector2d(4,4);
    private MapDirection direction;

    private Vector2d position;
    public Animal(){
        this(new Vector2d(2,2));
    }

    public Animal(Vector2d position){
        this.direction = MapDirection.NORTH;
        this.position = position;
    }

    @Override
    public String toString(){
        return switch (direction){
            case NORTH -> "^";
            case WEST -> "<";
            case SOUTH -> "v";
            case EAST -> ">";
        };
    }

    public boolean isAt(Vector2d position){
        return this.position.equals(position);
    }

    public void move(MoveDirection direction){
        switch (direction) {
            case FORWARD -> {
                if (canMoveForward()) {
                    this.position = this.position.add(this.direction.toUnitVector());
                }
            }
            case BACKWARD -> {
                if (canMoveBackward()) {
                    this.position = this.position.subtract(this.direction.toUnitVector());
                }
            }
            case RIGHT -> this.direction = this.direction.next();
            case LEFT -> this.direction = this.direction.previous();
        }
    }

    private boolean canMoveForward(){
        return position.add(this.direction.toUnitVector()).precedes(upperBound) && (lowerBound.precedes(position.add(this.direction.toUnitVector())));
    }

    private boolean canMoveBackward(){
        return position.subtract(this.direction.toUnitVector()).precedes(upperBound) && lowerBound.precedes(position.subtract(this.direction.toUnitVector()));
    }
    public MapDirection getDirection() {
        return this.direction;
    }
}
