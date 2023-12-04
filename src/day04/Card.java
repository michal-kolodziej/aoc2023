package day04;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class Card {
    private final int id;
    private final int amountOfMatches;
    private final int pointValue;

    public Card(String line) {
        //parsing example: Card 1: 41 48 83 86 17 | 83 86  6 31 17  9 48 53
        // idk if we're even gonna use this id xd
        id = Integer.parseInt(
                line
                        .replaceAll(" +", " ")
                        // remove multiple spaces - these occur in large input
                        .split(":")[0]
                        // "Card 1"
                        .split(" ")[1]);
                        // "1"
        Set<Integer> winningNumbers = Arrays.stream(
                line
                        .split(":")[1]
                        // "41 48 83 86 17 | 83 86  6 31 17  9 48 53"
                        .split("\\|")[0]
                        // "41 48 83 86 17 "
                        .strip()
                        // "41 48 83 86 17"
                        .replaceAll(" +", " ")
                        // "41 48 83 86 17" (needed when there are multiple spaces)
                        .split(" "))
                        // string array: [41,48,83,86,17]
                .map(Integer::parseInt)
                .collect(Collectors.toSet()
                );
        Set<Integer> numbersIHave = Arrays.stream(
                line
                        .split(":")[1]
                        .split("\\|")[1]
                        // the same thing as above but taking second element here
                        .strip()
                        .replaceAll(" +", " ")
                        .split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toSet());

        numbersIHave.retainAll(winningNumbers);
        this.amountOfMatches = numbersIHave.size();
        this.pointValue = (int) Math.pow(2, amountOfMatches);
    }

    public int getId() {
        return id;
    }

    public int getPointValue() {
        return pointValue;
    }

    public int getAmountOfMatches() {
        return amountOfMatches;
    }
}
