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

    void move(MoveDirection direction){
        return switch (direction){

            case FORWARD -> {
                if(this.position.add(this.direction.toUnitVector()).precedes(new Vector2d(0,0)) || ){

                }
            };
            case BACKWARD -> {

            };
            case RIGHT -> this.direction.next();
            case LEFT -> this.direction.previous();
        }
    }

}
