package day03;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

class SolutionPart2 {
    public static void main(String[] args) {
        new SolutionPart2().solve();
    }

    private void solve() {
        char[][] array = SolutionPart1.loadArray(Input.lines.split("\n"));
        List<FoundNumber> numbers = SolutionPart1.findNumbers(array);
        List<Point> gearCoords = findPositionsOf('*', array);
        int gearRatioSum = 0;
        for (Point gear : gearCoords){
            // not perfect solution, but will work in this case as amount of numbers is not gigantic.
            int gearRatio = 1;
            int partNumberCount = 0;
            for (FoundNumber number : numbers) {
                if(number.getAdjacentCoords().stream().anyMatch(point -> point.x == gear.x && point.y == gear.y)){
                    gearRatio *= number.getNumberAsInt();
                    partNumberCount++;
                }
            }
            // we add to sum only if there is at least two parts around this gear
            if(partNumberCount > 1){
                gearRatioSum += gearRatio;
            }
        }
        System.out.println(gearRatioSum);
    }

    private List<Point> findPositionsOf(char c, char[][] array) {
        List<Point> result = new ArrayList<>();
        for (int row = 0; row < array.length; row++) {
            for (int col = 0; col < array[row].length; col++) {
                if (array[row][col] == c) {
                    result.add(new Point(col, row));
                }
            }
        }
        return result;
    }
}
