package day03;

import java.util.ArrayList;
import java.util.List;

class SolutionPart1 {
    public static void main(String[] args) {
        new SolutionPart1().solve();
    }

    private void solve() {
        char[][] array = loadArray(Input.lines.split("\n"));
        List<FoundNumber> numbers = findNumbers(array);
        System.out.println(numbers.stream().filter(n -> isNextToSymbol(n, array)).mapToInt(FoundNumber::getNumberAsInt).sum());
    }

    private boolean isNextToSymbol(FoundNumber n, char[][] array) {
        return n.getAdjacentCoords().stream().anyMatch(point -> isSymbol(array[point.y][point.x]));
    }

    static List<FoundNumber> findNumbers(char[][] array) {
        List<FoundNumber> foundNumbers = new ArrayList<>();
        FoundNumber currentNumber = new FoundNumber();
        for (int row = 0; row < array.length; row++) {
            for (int col = 0; col < array[row].length; col++) {
                if (Character.isDigit(array[row][col])) {
                    // either we start a number, or we are inside a number
                    currentNumber.appendDigit(Character.getNumericValue(array[row][col]));
                    addCoords(currentNumber, row, col, array);
                } else {
                    // we either just exited a number or not
                    if (currentNumber.length() > 0) {
                        // just exited number, save it and reset
                        System.out.println(currentNumber.getNumberAsInt());
                        foundNumbers.add(currentNumber);
                        currentNumber = new FoundNumber();
                    }
                }
            }
        }
        return foundNumbers;
    }

    static void addCoords(FoundNumber currentNumber, int row, int col, char[][] array) {
        for (int r = Math.max(0, row - 1); r <= Math.min(row + 1, array.length - 1); r++) {
            for (int c = Math.max(0, col - 1); c <= Math.min(col + 1, array[0].length - 1); c++) {
                System.out.println("for row: " + row + ", and col: " + col  + ", adding point with coords: row:" + r + ", col: " + c);
                currentNumber.addCoord(r, c);
            }
        }
    }

    private boolean isSymbol(char ch) {
        return !Character.isDigit(ch) && ch != '.';
    }

    static char[][] loadArray(String[] split) {
        char[][] parsed = new char[split.length][split[0].length()];
        for (int row = 0; row < split.length; row++) {
            char[] chars = split[row].toCharArray();
            for (int col = 0; col < chars.length; col++) {
                parsed[row][col] = chars[col];
            }
        }
        return parsed;
    }
}
