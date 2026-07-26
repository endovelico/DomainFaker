package com.domain.faker.nfl.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import net.datafaker.Faker;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Game {

    private UUID id;

    private Season season;

    private int week;

    private LocalDateTime kickoff;

    private Team homeTeam;

    private Team awayTeam;

    private Stadium stadium;

    private GameStatus status;

    private Integer homeScore;

    private Integer awayScore;

    private GameStatistics statistics;

    private final Faker faker = new Faker();

    public Game fakeGame() {
        GameStatus status = fakeGameStatus();

        return Game.builder()
                .id(UUID.randomUUID())
                .season(season.fakeSeason())
                .week(faker.number().numberBetween(1, 18))
                .kickoff(fakeKickoff())
                .homeTeam(homeTeam.fakeTeam())
                .awayTeam(awayTeam.fakeTeam())
                .stadium(stadium.fakeStadium())
                .status(status)
                .homeScore(status == GameStatus.FINAL ? randomScore() : null)
                .awayScore(status == GameStatus.FINAL ? randomScore() : null)
                .statistics(status == GameStatus.FINAL
                        ? statistics.fakeGameStatistics()
                        : null)
                .build();
    }

    private GameStatus fakeGameStatus() {
        GameStatus[] statuses = GameStatus.values();
        return statuses[faker.number().numberBetween(0, statuses.length)];
    }

    private LocalDateTime fakeKickoff() {
        return LocalDateTime.now()
                .plusDays(faker.number().numberBetween(-200, 200))
                .withHour(faker.number().numberBetween(12, 21))
                .withMinute(0);
    }

    private int randomScore() {
        return faker.number().numberBetween(0, 50);
    }
}
