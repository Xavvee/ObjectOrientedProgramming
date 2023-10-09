package agh.ics.oop;

import agh.ics.oop.model.MoveDirection;

import java.util.Objects;

import static agh.ics.oop.model.MoveDirection.*;

public class OptionsParser {
    public static MoveDirection[] OptionsParser(String[] directions){
        int counter=0;
        for (String direction : directions) {
            if (Objects.equals(direction, "f") || direction == "r" || direction == "b" || direction == "l") {
                counter++;
            }
        }
        MoveDirection[] converted = new MoveDirection[counter];
        int index=0;
        for (String direction : directions) {
            switch (direction){
                case "f" -> {converted[index] = FORWARD; index++;}
                case "b" -> {converted[index] = BACKWARD; index++;}
                case "r" -> {converted[index] = RIGHT; index++;}
                case "l" -> {converted[index] = LEFT; index++;}
                default -> {}
            }
        }

        return converted;
    }
}

