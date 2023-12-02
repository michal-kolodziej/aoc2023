package day02;

import java.util.Arrays;
import java.util.List;

public class Game {
    private final int id;
    private final List<Round> rounds;

    //parse game to object
    Game(String line) {
        String[] splitBySemicolon = line.split(":");
        this.id = Integer.parseInt(splitBySemicolon[0].split(" ")[1]);
        this.rounds = Arrays.stream(splitBySemicolon[1].split(";"))
                .map(String::strip)
                .map(Round::new)
                .toList();
    }

    int getId() {
        return id;
    }

    List<Round> getRounds() {
        return rounds;
    }

    static class Round {
        int red;
        int green;
        int blue;

        Round(int red, int green, int blue) {
            this.red = red;
            this.green = green;
            this.blue = blue;
        }
        //parse single round to object
        Round(String roundString) {
            String[] strings = Arrays.stream(roundString.split(",")).map(String::strip).toArray(String[]::new);
            for (String s : strings) {
                String[] s1 = s.split(" ");
                int value = Integer.parseInt(s1[0]);
                switch (s1[1]) {
                    case "green" -> green += value;
                    case "red" -> red += value;
                    case "blue" -> blue += value;
                    default -> throw new RuntimeException("coś jest nie tak");
                }
            }
        }

        int getPower() {
            return red * green * blue;
        }
    }
}
