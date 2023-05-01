package ru.netology.game;

import ru.netology.domain.Player;
import ru.netology.notRegisteredException.NotRegisteredException;

import java.util.HashMap;
import java.util.Map;

public class Game {
    private HashMap<String, Player> players = new HashMap<>();

    public void register(String name, Player player) {
        players.put(name, player);
    }

    public int round(String playerName1, String playerName2) {
        Player player1 = players.get(playerName1);
        Player player2 = players.get(playerName2);
        for (Map.Entry<String, Player> player : players.entrySet()) {

            if (player.getValue().equals(playerName1)) {
                player1 = player.getValue();
            }
            if (player.getValue().equals(playerName2)) {
                player2 = player.getValue();
            }
        }

        if (player1 == null) {
            throw new NotRegisteredException(playerName1);
        }

        if (player2 == null) {
            throw new NotRegisteredException(playerName2);
        }

        if (player1.getStrength() > player2.getStrength()) {
            return 1;
        }
        if (player1.getStrength() < player2.getStrength()) {
            return 2;
        }
        return 0;
    }
}