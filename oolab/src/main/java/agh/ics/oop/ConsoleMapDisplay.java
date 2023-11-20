package agh.ics.oop;

import agh.ics.oop.model.MapChangeListener;
import agh.ics.oop.model.WorldMap;

public class ConsoleMapDisplay implements MapChangeListener {
    private int totalUpdates;

    public ConsoleMapDisplay(){
        this.totalUpdates = 0;
    }
    @Override
    public void mapChanged(WorldMap worldMap, String message) {
        totalUpdates += 1;
        System.out.println("Operation: " + message);
        System.out.println(worldMap.toString());
        System.out.println("Total number of changes: " + totalUpdates);
    }
}
