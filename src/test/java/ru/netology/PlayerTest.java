package ru.netology;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class PlayerTest {

//    @Test
//    public void shouldSumGenreIfOneGame() {
//        GameStore store = new GameStore();
//        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");
//
//        Player player = new Player("Petya");
//        player.installGame(game);
//        player.play(game, 3);
//
//        int expected = 3;
//        int actual = player.sumGenre(game.getGenre());
//        assertEquals(expected, actual);
//    }
//
//    // другие ваши тесты
//
//    @Test
//    public void shouldSumGenreTwoGames() {
//        GameStore store = new GameStore();
//        Game game1 = store.publishGame("Call of Duty", "Шутер");
//        Game game2 = store.publishGame("Apex Legends", "Шутер");
//        Game game3 = store.publishGame("Mortal Combat", "Файтинг");
//
//        Player player = new Player("Petya");
//        player.installGame(game1);
//        player.installGame(game2);
//        player.installGame(game3);
//        player.play(game1, 3);
//        player.play(game2, 2);
//        player.play(game3, 1);
//
//        int expected = 5;
//        int actual = player.sumGenre("Шутер");
//        assertEquals(expected, actual);
//    }
//
//    @Test
//    public void shouldThrowRunTimeException() {
//        GameStore store = new GameStore();
//        Game game1 = store.publishGame("Call of Duty", "Шутер");
//        Game game2 = store.publishGame("Apex Legends", "Шутер");
//        Game game3 = store.publishGame("Mortal Combat", "Файтинг");
//
//        Player player = new Player("Petya");
//        player.installGame(game1);
//        player.installGame(game2);
//
//        assertThrows(RuntimeException.class, () -> {
//            player.play(game3, 1);
//        });
//    }
//
//    @Test
//    public void shouldMostPlayerByGenre() {
//        GameStore store = new GameStore();
//        Game game1 = store.publishGame("Call of Duty", "Шутер");
//        Game game3 = store.publishGame("Apex Legends", "Файтинг");
//        Game game4 = store.publishGame("Allods online", "MMORPG");
//
//        Player player = new Player("Petya");
//        player.installGame(game1);
//        player.installGame(game3);
//        player.installGame(game4);
//        player.play(game1, 2);
//        player.play(game3, 4);
//        player.play(game4, 3);
//
//        Game expected = game3;
//        Game actual = player.mostPlayerByGenre("Файтинг");
//        assertEquals(expected, actual);
//    }
//
//    @Test
//    public void shouldAddDoubleGame() {
//        GameStore store = new GameStore();
//        Game game1 = store.publishGame("Call of Dute", "Шутер");
//        Game game2 = store.publishGame("Apex Legends", "Шутер");
//        Game game3 = store.publishGame("Mortal Kombat", "Файтинг");
//
//        Player player = new Player("Петя");
//        player.installGame(game1);
//        player.play(game1, 2);
//        player.installGame(game1);
//
//        int expected = 2;
//        int actual = player.sumGenre(game1.getGenre());
//        assertEquals(expected, actual);
//    }


    //sumGenre: следует посчитать суммарное время одной игры
    @Test
    public void shouldCheckSumGenreIfOneGame() {
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        Player player = new Player("Petya");
        player.installGame(game);
        player.play(game, 3);

        int expected = 3;
        int actual = player.sumGenre(game.getGenre());
        assertEquals(expected, actual);
    }

    //sumGenre: следует переустановить игру и проверить наигранное время
    @Test
    public void shouldAddDoubleGame() {
        GameStore store = new GameStore();
        Game game1 = store.publishGame("Call of Dute", "Шутер");
        Game game2 = store.publishGame("Apex Legends", "Шутер");
        Game game3 = store.publishGame("Mortal Kombat", "Файтинг");

        Player player = new Player("Петя");
        player.installGame(game1);
        player.play(game1, 2);
        player.installGame(game1);

        int expected = 2;
        int actual = player.sumGenre(game1.getGenre());
        assertEquals(expected, actual);
    }

    //sumGenre: следует посчитать суммарное время двух игр в одном жанре
    @Test
    public void shouldCheckSumGenreTwoGames() {
        GameStore store = new GameStore();
        Game game1 = store.publishGame("Call of Dute", "Шутер");
        Game game2 = store.publishGame("Apex Legends", "Шутер");
        Game game3 = store.publishGame("Mortal Kombat", "Файтинг");

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

    //sumGenre: следует посчитать суммарное время игры, если 0 часов наиграно
    // тест проходит
    @Test
    public void shouldCheckSumGenreIfPlayZeroTime() {
        GameStore store = new GameStore();
        Game game1 = store.publishGame("Call of Dute", "Шутер");
        Game game2 = store.publishGame("Apex Legends", "Шутер");
        Game game3 = store.publishGame("Mortal Kombat", "Файтинг");

        Player player = new Player("Petya");
        player.installGame(game1);
        player.installGame(game2);
        player.installGame(game3);
        player.play(game1, 0);
        player.play(game2, 0);
        player.play(game3, 0);

        int expected = 0;
        int actual = player.sumGenre(game1.getGenre());

        assertEquals(expected, actual);
    }

    //play: следует проверить выпадение RuntimeException, если игра не установлена
    //тест 1: ни одна игра не установлена
    @Test
    public void shouldCheckPlayWithoutInstall() {
        GameStore store = new GameStore();
        Game game1 = store.publishGame("Call of Dute", "Шутер");
        Game game2 = store.publishGame("Apex Legends", "Шутер");
        Game game3 = store.publishGame("Mortal Kombat", "Файтинг");

        Player player = new Player("Petya");

        assertThrows(RuntimeException.class, () ->
                player.play(game2, 1)
        );
    }

    // тест 2: установлены две игры из трех
    @Test
    public void shouldCheckThrowRunTimeException() {
        GameStore store = new GameStore();
        Game game1 = store.publishGame("Call of Dute", "Шутер");
        Game game2 = store.publishGame("Apex Legends", "Шутер");
        Game game3 = store.publishGame("Mortal Kombat", "Файтинг");

        Player player = new Player("Petya");
        player.installGame(game1);
        player.installGame(game2);


        assertThrows(RuntimeException.class, () -> {
            player.play(game3, 1);

        });
    }

    //mostPlayerByGenre: следует вернуть жанр, в который играли больше всего
    @Test
    public void shouldCheckMostPlayerByGenre() {
        GameStore store = new GameStore();
        Game game1 = store.publishGame("Call of Dute", "Шутер");
        Game game3 = store.publishGame("Mortal Kombat", "Файтинг");
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

    //mostPlayerByGenre: следует вернуть null, если в игры этого жанра не играли
    //тест проходит
    @Test
    public void shouldCheckMostPlayerByGenreNoInstallGame() {
        GameStore store = new GameStore();
        Game game1 = store.publishGame("Call of Dute", "Шутер");
        Game game2 = store.publishGame("Apex Legends", "Шутер");
        Game game3 = store.publishGame("Mortal Kombat", "Файтинг");
        Game game4 = store.publishGame("Allods online", "MMORPG");

        Player player = new Player("Petya");
        player.installGame(game1);
        player.installGame(game2);
        player.installGame(game3);
        player.installGame(game4);
        player.play(game1, 3);
        player.play(game2, 2);
        player.play(game3, 4);
        player.play(game4, 1);


        String expected = null;
        Game actual = player.mostPlayerByGenre("Аркады");
        assertEquals(expected, actual);
    }

    //mostPlayerByGenre: следует вернуть null, если время отрицательное
    @Test
    public void shouldCheckMostPlayerByGenreWithUnacceptableTime() {
        GameStore store = new GameStore();
        Game game1 = store.publishGame("Call of Dute", "Шутер");
        Game game2 = store.publishGame("Apex Legends", "Шутер");

        Player player = new Player("Petya");
        player.installGame(game1);
        player.play(game1, -1);

        String expected = null;
        Game actual = player.mostPlayerByGenre("Шутер");

        assertEquals(expected, actual);
    }
}