package agh.ics.oop;

public enum MapDirection {
    NORTH,
    SOUTH,
    WEST,
    EAST;

    @Override
    public String toString(){

    }

    public MapDirection next(){
        switch (this){
            case NORTH -> ;
            case SOUTH -> ;
            case EAST -> ;
            case WEST -> ;
            default -> {}
        }
    }

    public MapDirection previous(){
        switch (this){
            case NORTH -> WEST;
            case WEST -> SOUTH;
            case EAST -> NORTH;
            case SOUTH -> EAST;
            default -> {}
        }
    }

    public Vector2d toUnitVector(){
        switch (this){
            case NORTH -> new Vector2d(0,1);
            case SOUTH -> new Vector2d(0, -1);
            case EAST -> new Vector2d(1,0);
            case WEST -> new Vector2d(-1,0);
            default -> {}
        }
    }
}
