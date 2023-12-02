package day02;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class SolutionPart1 {
    public static void main(String[] args) {
        new SolutionPart1().solve();
    }

    private void solve() {
        List<Game> games = Arrays.stream(Input.lines.split("\n")).map(Game::new)
                .toList();
        int sum = games.stream().filter(this::isPossible)
                .mapToInt(Game::getId)
                .sum();
        System.out.println(sum);
    }

    private boolean isPossible(Game game) {
        for (Game.Round r : game.getRounds()) {
            if(r.green > 13 || r.red > 12 || r.blue > 14) return false;
        }
        return true;
    }
}
