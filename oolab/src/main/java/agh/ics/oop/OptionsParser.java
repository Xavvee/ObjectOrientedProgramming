package agh.ics.oop;

import agh.ics.oop.model.MoveDirection;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

import static agh.ics.oop.model.MoveDirection.*;

public class OptionsParser {
    public static List<MoveDirection> parser(String[] directions){
        List<MoveDirection> directionList = new LinkedList<>();
//        for (String direction : directions) {
//            if (Objects.equals(direction, "f") || Objects.equals(direction, "r") || Objects.equals(direction, "b") || Objects.equals(direction, "l")) {
//                directionList.add(MoveDirection.valueOf(direction));
//            }
//        }
        for (String direction : directions) {
            switch (direction){
                case "f" -> directionList.add(FORWARD);
                case "b" -> directionList.add(BACKWARD);
                case "r" -> directionList.add(RIGHT);
                case "l" -> directionList.add(LEFT);
                default -> {}
            }
        }

        return directionList;
    }
}

