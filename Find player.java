import java.util.*;

class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {

        Map<Integer, Integer> losses = new HashMap<>();

        // Count losses
        for (int[] match : matches) {

            int winner = match[0];
            int loser = match[1];

            // Make sure winner is also recorded
            losses.putIfAbsent(winner, 0);

            // Increase loser's loss count
            losses.put(loser, losses.getOrDefault(loser, 0) + 1);
        }

        List<Integer> zeroLosses = new ArrayList<>();
        List<Integer> oneLoss = new ArrayList<>();

        // Categorize players
        for (int player : losses.keySet()) {

            int lossCount = losses.get(player);

            if (lossCount == 0) {
                zeroLosses.add(player);
            }
            else if (lossCount == 1) {
                oneLoss.add(player);
            }
        }

        // Sort both lists
        Collections.sort(zeroLosses);
        Collections.sort(oneLoss);

        List<List<Integer>> result = new ArrayList<>();

        result.add(zeroLosses);
        result.add(oneLoss);

        return result;
    }
}
