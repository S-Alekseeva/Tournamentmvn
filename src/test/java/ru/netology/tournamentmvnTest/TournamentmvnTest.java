package ru.netology.tournamentmvnTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Player;
import ru.netology.game.Game;
import ru.netology.notRegisteredException.NotRegisteredException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TournamentmvnTest {

    Game game = new Game();

    Player player1 = new Player(111, "Cobra", 1500);
    Player player2 = new Player(222, "Tiger", 500);
    Player player3 = new Player(333, "Loser", 8);
    Player player4 = new Player(444, "Hero", 300);
    Player player5 = new Player(555, "Cat", 1500);

    @Test
    public void shouldIfPlayer1Wins() {
        game.register("Cobra", player1);
        game.register("Tiger", player2);
        game.register("Loser", player3);
        game.register("Hero", player4);
        game.register("Cat", player5);

        assertEquals(1, game.round("Cobra", "Hero"));
    }

    @Test
    public void shouldIfPlayer2Wins() {
        game.register("Cobra", player1);
        game.register("Tiger", player2);
        game.register("Loser", player3);
        game.register("Hero", player4);
        game.register("Cat", player5);

        assertEquals(2, game.round("Loser", "Hero"));
    }

    @Test
    public void shouldIfDraw() {
        game.register("Cobra", player1);
        game.register("Tiger", player2);
        game.register("Loser", player3);
        game.register("Hero", player4);
        game.register("Cat", player5);

        assertEquals(0, game.round("Cobra", "Cat"));
    }

    @Test
    public void shouldIfPlayer1NotRegistered() {
        game.register("Cobra", player1);
        game.register("Tiger", player2);
        game.register("Loser", player3);
        game.register("Hero", player4);
        game.register("Cat", player5);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Oleg", "Cobra");
        });
    }

    @Test
    public void shouldIfPlayer2NotRegistered() {
        game.register("Cobra", player1);
        game.register("Tiger", player2);
        game.register("Loser", player3);
        game.register("Hero", player4);
        game.register("Cat", player5);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Tiger", "Masha");
        });
    }

    @Test
    public void shouldIfPlayersNotRegistered() {
        game.register("Cobra", player1);
        game.register("Tiger", player2);
        game.register("Loser", player3);
        game.register("Hero", player4);
        game.register("Cat", player5);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Vasya", "Alex");
        });
    }
}
