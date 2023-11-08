package agh.ics.oop.model;


import java.util.HashMap;


public class RectangularMap extends AbstractWorldMap {
    private final int height;
    private final int width;

    public RectangularMap(int height, int width){
        this.height = height;
        this.width = width;
        this.animals = new HashMap<>();
    }


    @Override
    public boolean canMoveTo(Vector2d position) {
        return super.canMoveTo(position) && !isOccupied(position);
    }


    public Vector2d getLowerLeft(){
        return new Vector2d(0,0);
    }

    public Vector2d getUpperRight(){
        return new Vector2d(width, height);
    }

    @Override
    protected Vector2d getLeftBound() {
        return getLowerLeft();
    }

    @Override
    protected Vector2d getRightBound() {
        return getUpperRight();
    }

    @Override
    public String toString(){
        return visualizer.draw(this.getLowerLeft(), this.getUpperRight());
    }
}
