package org.example;

import lombok.Data;
import org.apache.commons.math3.random.RandomDataGenerator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
class GameResult {
    private String winner;
    private String loser;
}

public class GameStatistics {
    public static void main(String[] args) {
        List<GameResult> gameResults = new ArrayList<>();

        // Имитация игры и запись результатов
        RandomDataGenerator randomDataGenerator = new RandomDataGenerator();
        for (int i = 0; i < 10; i++) {
            int winnerScore = randomDataGenerator.nextInt(0, 1);
            int loserScore = winnerScore == 0 ? 1 : 0;
            GameResult gameResult = new GameResult();
            gameResult.setWinner("Player" + (i + 1));
            gameResult.setLoser("Player" + (i + 2));
            gameResults.add(gameResult);
        }

        // Подсчет статистики по победам и поражениям
        Map<String, Integer> winCount = new HashMap<>();
        Map<String, Integer> loseCount = new HashMap<>();

        for (GameResult gameResult : gameResults) {
            winCount.put(gameResult.getWinner(), winCount.getOrDefault(gameResult.getWinner(), 0) + 1);
            loseCount.put(gameResult.getLoser(), loseCount.getOrDefault(gameResult.getLoser(), 0) + 1);
        }

        // Вывод статистики
        System.out.println("Статистика побед:");
        winCount.forEach((player, wins) -> System.out.println(player + ": " + wins));

        System.out.println("\nСтатистика поражений:");
        loseCount.forEach((player, loses) -> System.out.println(player + ": " + loses));
    }
}