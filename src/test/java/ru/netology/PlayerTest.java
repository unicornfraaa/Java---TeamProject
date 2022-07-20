package ru.netology;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class PlayerTest {

    @Test
    public void shouldSumGenreIfOneGame() {
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        Player player = new Player("Petya");
        player.installGame(game);
        player.play(game, 3);

        int expected = 3;
        int actual = player.sumGenre(game.getGenre());
        assertEquals(expected, actual);
    }

    // другие ваши тесты

    @Test
    public void shouldSumGenreTwoGames() {
        GameStore store = new GameStore();
        Game game1 = store.publishGame("Call of Duty", "Шутер");
        Game game2 = store.publishGame("Apex Legends", "Шутер");
        Game game3 = store.publishGame("Mortal Combat", "Файтинг");

        Player player = new Player("Petya");
        player.installGame(game1);
        player.installGame(game2);
        player.installGame(game3);
        player.play(game1, 3);
        player.play(game2, 2);
        player.play(game3, 1);

        int expected = 5;
        int actual = player.sumGenre("Шутер");
        assertEquals(expected, actual);
    }

    @Test
    public void shouldThrowRunTimeException() {
        GameStore store = new GameStore();
        Game game1 = store.publishGame("Call of Duty", "Шутер");
        Game game2 = store.publishGame("Apex Legends", "Шутер");
        Game game3 = store.publishGame("Mortal Combat", "Файтинг");

        Player player = new Player("Petya");
        player.installGame(game1);
        player.installGame(game2);

        assertThrows(RuntimeException.class, () -> {
            player.play(game3, 1);
        });
    }

    @Test
    public void shouldMostPlayerByGenre() {
        GameStore store = new GameStore();
        Game game1 = store.publishGame("Call of Duty", "Шутер");
        Game game3 = store.publishGame("Apex Legends", "Файтинг");
        Game game4 = store.publishGame("Allods online", "MMORPG");

        Player player = new Player("Petya");
        player.installGame(game1);
        player.installGame(game3);
        player.installGame(game4);
        player.play(game1, 2);
        player.play(game3, 4);
        player.play(game4, 3);

        Game expected = game3;
        Game actual = player.mostPlayerByGenre("Файтинг");
        assertEquals(expected, actual);
    }

//    @Test
//    public void shouldAddDoubleGame() {
//
//    }
}