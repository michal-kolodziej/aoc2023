package day02;

import java.util.Arrays;
import java.util.List;

class SolutionPart2 {
    public static void main(String[] args) {
        new SolutionPart2().solve();
    }

    private void solve() {
        List<Game> games = Arrays.stream(Input.lines.split("\n")).map(Game::new)
                .toList();
        int sum = games.stream().map(this::calculateMaxRound)
                .mapToInt(Game.Round::getPower)
                .sum();
        System.out.println(sum);
    }

    Game.Round calculateMaxRound(Game game) {
        int maxRed = 0;
        int maxGreen = 0;
        int maxBlue = 0;
        for (Game.Round round : game.getRounds()) {
            if (round.red > maxRed) maxRed = round.red;
            if (round.green > maxGreen) maxGreen = round.green;
            if (round.blue > maxBlue) maxBlue = round.blue;
        }
        return new Game.Round(maxRed, maxGreen, maxBlue);
    }
}
