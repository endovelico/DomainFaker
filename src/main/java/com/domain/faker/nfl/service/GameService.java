package com.domain.faker.nfl.service;

import com.domain.faker.nfl.model.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.IntStream;

@Service
@RequiredArgsConstructor
public class GameService {

    private final Game gameFaker = new Game();
    private final Team teamFaker = new Team();
    private final Season seasonFaker = new Season();
    private final GameStatistics statisticsFaker = new GameStatistics();

    public List<Game> getSchedule() {
        return IntStream.range(0, 272)
                .mapToObj(i -> gameFaker.fakeGame())
                .toList();
    }

    public List<Game> getSchedule(int seasonYear) {
        return IntStream.range(0, 272)
                .mapToObj(i -> {
                    Game game = gameFaker.fakeGame();
                    game.getSeason().setYear(seasonYear);
                    return game;
                })
                .toList();
    }

    public List<Game> getGamesByWeek(int seasonYear, int week) {
        return IntStream.range(0, 16)
                .mapToObj(i -> {
                    Game game = gameFaker.fakeGame();
                    game.getSeason().setYear(seasonYear);
                    game.setWeek(week);
                    return game;
                })
                .toList();
    }

    public List<Game> getGamesByTeam(UUID teamId) {
        return IntStream.range(0, 17)
                .mapToObj(i -> {
                    Game game = gameFaker.fakeGame();
                    game.setHomeTeam(teamFaker.fakeTeam());
                    game.getHomeTeam().setId(teamId);
                    return game;
                })
                .toList();
    }

    public Game getGame(UUID gameId) {
        Game game = gameFaker.fakeGame();
        game.setId(gameId);
        return game;
    }

    public GameStatistics getGameStatistics(UUID gameId) {
        return statisticsFaker.fakeGameStatistics();
    }

    public List<Game> getUpcomingGames() {
        return IntStream.range(0, 10)
                .mapToObj(i -> {
                    Game game = gameFaker.fakeGame();
                    game.setStatus(GameStatus.SCHEDULED);
                    game.setHomeScore(null);
                    game.setAwayScore(null);
                    game.setStatistics(null);
                    return game;
                })
                .toList();
    }

    public List<Game> getCompletedGames() {
        return IntStream.range(0, 20)
                .mapToObj(i -> {
                    Game game = gameFaker.fakeGame();
                    game.setStatus(GameStatus.FINAL);
                    game.setStatistics(statisticsFaker.fakeGameStatistics());
                    return game;
                })
                .toList();
    }

    public List<Game> getLiveGames() {
        return IntStream.range(0, 3)
                .mapToObj(i -> {
                    Game game = gameFaker.fakeGame();
                    game.setStatus(GameStatus.IN_PROGRESS);
                    return game;
                })
                .toList();
    }

    public Season getCurrentSeason() {
        return seasonFaker.fakeSeason();
    }
}
