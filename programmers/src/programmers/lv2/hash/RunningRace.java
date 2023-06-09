package programmers.lv2.hash;

import java.util.*;
import java.util.stream.*;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/178871
 */
public class RunningRace {
    public static void main(String[] args) {
        RunningRace runningRace = new RunningRace();
        String[] players = {"mumu", "soe", "poe", "kai", "mine"};
        String[] callings = {"kai", "kai", "mine", "mine"};

        runningRace.solution(players, callings);
    }

    public String[] solution(String[] players, String[] callings) {
        Map<Integer, String> mappedByRank = mappedByRank(players);
        Map<String, Integer> mappedByPlayer = mappedByPlayer(players);

        Arrays.stream(callings)
                .forEach(calling -> {
                    int rank = rankOf(mappedByPlayer, calling);

                    String moveForwardPlayer = playerOf(mappedByRank, rank);
                    String moveBackwardPlayer = playerOf(mappedByRank, rank-1);

                    mappedByRank.put(rank-1, moveForwardPlayer);
                    mappedByRank.put(rank, moveBackwardPlayer);

                    mappedByPlayer.put(moveForwardPlayer, rank-1);
                    mappedByPlayer.put(moveBackwardPlayer, rank);
                });

        String[] raceResult = new String[players.length];
        mappedByRank.keySet()
                .forEach(rank -> raceResult[rank] = mappedByRank.get(rank));

        return raceResult;
    }

    private String playerOf(Map<Integer, String> mappedByRank, int rank) {
        return mappedByRank.get(rank);
    }

    private int rankOf(Map<String, Integer> mappedByPlayer, String player) {
        return mappedByPlayer.get(player);
    }

    private Map<Integer, String> mappedByRank(String[] players) {
        Map<Integer, String> mappedByRank = new HashMap<>();
        IntStream.range(0, players.length)
                .forEach(index -> mappedByRank.put(index, players[index]));

        return mappedByRank;
    }

    private Map<String, Integer> mappedByPlayer(String[] players) {
        Map<String, Integer> mappedByPlayer = new HashMap<>();
        IntStream.range(0, players.length)
                .forEach(index -> mappedByPlayer.put(players[index], index));

        return mappedByPlayer;
    }
}
