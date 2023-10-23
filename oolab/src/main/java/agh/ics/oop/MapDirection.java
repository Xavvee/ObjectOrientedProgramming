package agh.ics.oop;

public enum MapDirection {
    NORTH,
    SOUTH,
    WEST,
    EAST;

    @Override
    public String toString(){
        return switch (this){
            case EAST -> "Wschód";
            case WEST -> "Zachód";
            case NORTH -> "Północ";
            case SOUTH -> "Południe";
        };
    }

    public MapDirection next(){
        return switch (this){
            case NORTH -> EAST;
            case SOUTH -> WEST;
            case EAST -> SOUTH;
            case WEST -> NORTH;
        };
    }

    public MapDirection previous(){
        return switch (this){
            case NORTH -> WEST;
            case WEST -> SOUTH;
            case EAST -> NORTH;
            case SOUTH -> EAST;
        };
    }

    public Vector2d toUnitVector(){
        switch (this){
            case NORTH -> {
                return new Vector2d(0,1);
            }
            case SOUTH -> {
                return new Vector2d(0, -1);
            }
            case EAST -> {
                return new Vector2d(1,0);
            }
            case WEST -> {
                return new Vector2d(-1,0);
            }
        }
        return null;
    }
}
