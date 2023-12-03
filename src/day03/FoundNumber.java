package day03;

import java.awt.Point;
import java.util.HashSet;
import java.util.Set;

public class FoundNumber {
    private String numberString = "";
    private final Set<Point> coords = new HashSet<>();

    void addCoord(int row, int col){
        Point point = new Point(col, row);
        coords.add(point);
    }
    Set<Point> getAdjacentCoords(){
        return coords;
    }

    void appendDigit(int digit){
        numberString += digit;
    }

    int getNumberAsInt(){
        if (numberString.length() < 1) throw new RuntimeException("number cannot is empty, cannot get as int");
        return Integer.parseInt(numberString);
    }

    int length() {
        return numberString.length();
    }
}
