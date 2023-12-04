package day04;

import java.util.Arrays;

class SolutionPart1 {
    public static void main(String[] args) {
        new SolutionPart1().solve();
    }

    private void solve() {
        int cardValuesSum = Arrays.stream(Input.lines.split("\n"))
                .map(Card::new)
                .mapToInt(Card::getPointValue)
                .sum();
        System.out.println(cardValuesSum);
    }
}
