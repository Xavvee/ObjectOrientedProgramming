package agh.ics.oop.model;

public class Animal {

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
        return this.position + ", " + this.direction;
    }

    public boolean isAt(Vector2d position){
        return this.position.equals(position);
    }

    public void move(MoveDirection direction){
        switch (direction) {
            case FORWARD -> {
                if ((position.add(this.direction.toUnitVector()).precedes(new Vector2d(4, 4))) && (new Vector2d(0, 0).precedes(position.add(this.direction.toUnitVector())))) {
                    this.position = this.position.add(this.direction.toUnitVector());
                }
            }
            case BACKWARD -> {
                if ((position.subtract(this.direction.toUnitVector()).precedes(new Vector2d(4, 4))) && (new Vector2d(0, 0).precedes(position.subtract(this.direction.toUnitVector())))) {
                    this.position = this.position.subtract(this.direction.toUnitVector());
                }
            }
            case RIGHT -> this.direction = this.direction.next();
            case LEFT -> this.direction = this.direction.previous();
        }
    }

}
