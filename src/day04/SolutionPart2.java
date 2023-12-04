package day04;

import java.util.Arrays;
import java.util.List;

class SolutionPart2 {
    public static void main(String[] args) {
        new SolutionPart2().solve();
    }

    private void solve() {
        List<Card> cards = Arrays.stream(Input.lines.split("\n"))
                .map(Card::new)
                .toList();
        int totalCardSum = cards.stream().mapToInt(card -> countCardsRecursively(card, 0, cards)).sum();
        System.out.println(totalCardSum);
    }

    private int countCardsRecursively(Card card, int currentTreeSum, List<Card> allCards) {
        currentTreeSum += 1;
        for (int i = card.getId() + 1; i <= card.getId() + card.getAmountOfMatches(); i++) {
            currentTreeSum = countCardsRecursively(cardWithId(i, allCards), currentTreeSum, allCards);
        }
        return currentTreeSum;
    }

    private Card cardWithId(int i, List<Card> allCards) {
        return allCards.stream().filter(card -> card.getId() == i).findFirst()
                .orElseThrow(() -> new RuntimeException("something is very wrong."));
    }
}
