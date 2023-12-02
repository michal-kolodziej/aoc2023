package day1;

import java.util.List;

class SolutionPart1 {
    public static void main(String[] args) {
        new SolutionPart1().solve();
    }

    private static List<String> testInputPt2() {
        return List.of(("two1nine\n"
                + "eightwothree\n"
                + "abcone2threexyz\n"
                + "xtwone3four\n"
                + "4nineeightseven2\n"
                + "zoneight234\n"
                + "7pqrstsixteen").split("\n"));
    }

    private void solve() {
        System.out.println(solve(List.of(Input.lines.split("\n"))));
    }

    int solve(List<String> lines) {
        return lines.stream().map(this::solveLine)
                .reduce(0, Integer::sum);
    }

    int solve2(List<String> lines) {
        return lines.stream().map(this::solveLine2)
                .reduce(0, Integer::sum);
    }

    private int solveLine(String s) {
        char[] chars = s.toCharArray();
        int result = 0;
        for (int leftToRight = 0; leftToRight < chars.length; leftToRight++) {
            if (Character.isDigit(chars[leftToRight])) {
                result += Character.getNumericValue(chars[leftToRight]) * 10;
                break;
            }
        }

        for (int rightToLeft = chars.length - 1; rightToLeft >= 0; rightToLeft--) {
            if (Character.isDigit(chars[rightToLeft])) {
                result += Character.getNumericValue(chars[rightToLeft]);
                break;
            }
        }
        return result;
    }

    private int solveLine2(String line) {
        int result = 0;
        for (int i = 0; i < line.length(); i++) {
            if (Character.isDigit(line.toCharArray()[i])) {
                result += Character.getNumericValue(line.toCharArray()[i]) * 10;
                break;
            }
            int numberAtIndex = getNumberAtIndex(line, i);
            if (numberAtIndex > 0) {
                result += numberAtIndex * 10;
                break;
            }
        }

        for (int i = line.length() - 1; i >= 0; i--) {
            if (Character.isDigit(line.toCharArray()[i])) {
                result += Character.getNumericValue(line.toCharArray()[i]);
                break;
            }
            int numberAtIndex = getNumberAtIndex(line, i);
            if (numberAtIndex > 0) {
                result += numberAtIndex;
                break;
            }
        }

        return result;
    }

    private int getNumberAtIndex(String line, int i) {
        String[] nums = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        for (int k = 1; k < nums.length; k++) {
            String num = nums[k];
            if (i + num.length() > line.length()) continue;

            if (isNumberAtIndex(line, nums[k], i)) {
                System.out.println("number: " + k + " at index: " + i + " in string: " + line);
                return k;
            }
        }
        return -1;
    }

    private boolean isNumberAtIndex(String line, String num, int index) {
        char[] chars = num.toCharArray();
        for (int i = 0; i < num.length(); i++) {
            if (chars[i] != line.charAt(index + i)) return false;
        }
        return true;
    }
}
