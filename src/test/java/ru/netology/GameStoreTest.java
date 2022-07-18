package ru.netology;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class GameStoreTest {

    @Test
    public void shouldAddGame() {

        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        assertTrue(store.containsGame(game));
    }

    @Test
    public void shouldAddPlayerTime() {
        GameStore store = new GameStore();
        Player player1 = new Player("Petya");
        Player player2 = new Player("Kirill");

        store.addPlayTime(player1.getName(), 0);
        store.addPlayTime(player2.getName(), 1);

        String expected = "Kirill";
        String actual = store.getMostPlayer();

        assertEquals(expected, actual);
    }
    @Test
    public void shouldSumPlayerTime() {
        GameStore store = new GameStore();
        Player player1 = new Player("Petya");
        Player player2 = new Player("Kirill");

        store.addPlayTime(player1.getName(), 1);
        store.addPlayTime(player2.getName(), 2);

        int expected = 3;
        int actual = store.getSumPlayedTime();

        assertEquals(expected, actual);
    }

    @Test
    public void shouldAddPlayerTimeToTime() {
        GameStore store = new GameStore();
        Player player1 = new Player("Petya");
        Player player2 = new Player("Kirill");

        store.addPlayTime(player1.getName(), 1);
        store.addPlayTime(player2.getName(), 2);
        store.addPlayTime(player1.getName(), 3);
        store.addPlayTime(player2.getName(), 4);

        int expected = 10;
        int actual = store.getSumPlayedTime();

        assertEquals(expected, actual);
    }
    @Test
    public void equalPlayedTime() {
        GameStore store = new GameStore();
        Player player1 = new Player("Petya");
        Player player2 = new Player("Kirill");

        store.addPlayTime(player1.getName(), 1);
        store.addPlayTime(player2.getName(), 1);
        store.addPlayTime(player1.getName(), 2);
        store.addPlayTime(player2.getName(), 2);

        String[] expected = {"Petya", "Kirill"};
        String[] actual = {store.getMostPlayer()};

        assertArrayEquals(expected, actual);
    }
}