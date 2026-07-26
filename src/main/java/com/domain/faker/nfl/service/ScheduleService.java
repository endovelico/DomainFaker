package com.domain.faker.nfl.service;

import com.domain.faker.nfl.model.Game;
import com.domain.faker.nfl.model.GameStatus;
import com.domain.faker.nfl.model.Season;
import com.domain.faker.nfl.model.Team;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.IntStream;

@Service
@RequiredArgsConstructor
public class ScheduleService {

    private final Game gameFaker = new Game();
    private final Season seasonFaker = new Season();
    private final Team teamFaker = new Team();

    public List<Game> getSeasonSchedule(int seasonYear) {
        return IntStream.range(0, 272)
                .mapToObj(i -> {
                    Game game = gameFaker.fakeGame();
                    game.getSeason().setYear(seasonYear);
                    return game;
                })
                .toList();
    }

    public List<Game> getWeekSchedule(int seasonYear, int week) {
        return IntStream.range(0, 16)
                .mapToObj(i -> {
                    Game game = gameFaker.fakeGame();
                    game.getSeason().setYear(seasonYear);
                    game.setWeek(week);
                    return game;
                })
                .toList();
    }

    public List<Game> getTeamSchedule(UUID teamId) {
        Team team = teamFaker.fakeTeam();
        team.setId(teamId);

        return IntStream.range(0, 17)
                .mapToObj(i -> {
                    Game game = gameFaker.fakeGame();

                    if (i % 2 == 0) {
                        game.setHomeTeam(team);
                    } else {
                        game.setAwayTeam(team);
                    }

                    return game;
                })
                .toList();
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

    public Game getNextGame(UUID teamId) {
        Game game = gameFaker.fakeGame();
        game.setStatus(GameStatus.SCHEDULED);
        return game;
    }

    public List<Game> getTodayGames() {
        return IntStream.range(0, 8)
                .mapToObj(i -> {
                    Game game = gameFaker.fakeGame();
                    game.setKickoff(LocalDateTime.now().plusHours(i));
                    return game;
                })
                .toList();
    }

    public Season getCurrentSeason() {
        return seasonFaker.fakeSeason();
    }
}
