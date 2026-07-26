package com.domain.faker.nfl.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import net.datafaker.Faker;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class PlayerStatistics {

    // Passing
    private int passingAttempts;
    private int passingCompletions;
    private int passingYards;
    private int passingTouchdowns;
    private int passingInterceptions;
    private double passerRating;

    // Rushing
    private int rushingAttempts;
    private int rushingYards;
    private int rushingTouchdowns;

    // Receiving
    private int receptions;
    private int receivingYards;
    private int receivingTouchdowns;

    // Defense
    private int tackles;
    private int assistedTackles;
    private int sacks;
    private int interceptions;
    private int forcedFumbles;
    private int fumbleRecoveries;
    private int passesDefended;

    // Special Teams
    private int kickReturns;
    private int kickReturnYards;
    private int puntReturns;
    private int puntReturnYards;

    // General
    private int fumbles;
    private int gamesPlayed;
    private int gamesStarted;

    private final Faker faker = new Faker();

    public PlayerStatistics fakePlayerStatistics() {

        int passingAttempts = faker.number().numberBetween(0, 700);
        int rushingAttempts = faker.number().numberBetween(0, 300);
        int receptions = faker.number().numberBetween(0, 120);

        int gamesPlayed = faker.number().numberBetween(1, 17);
        int gamesStarted = faker.number().numberBetween(0, gamesPlayed + 1);

        int passingCompletions = faker.number()
                .numberBetween(0, passingAttempts + 1);

        return PlayerStatistics.builder()

                // Passing
                .passingAttempts(passingAttempts)
                .passingCompletions(passingCompletions)
                .passingYards(faker.number().numberBetween(0, 5500))
                .passingTouchdowns(faker.number().numberBetween(0, 55))
                .passingInterceptions(faker.number().numberBetween(0, 25))
                .passerRating(fakePasserRating())

                // Rushing
                .rushingAttempts(rushingAttempts)
                .rushingYards(faker.number().numberBetween(0, 2000))
                .rushingTouchdowns(faker.number().numberBetween(0, 20))

                // Receiving
                .receptions(receptions)
                .receivingYards(faker.number().numberBetween(0, 2000))
                .receivingTouchdowns(faker.number().numberBetween(0, 20))

                // Defense
                .tackles(faker.number().numberBetween(0, 150))
                .assistedTackles(faker.number().numberBetween(0, 80))
                .sacks(faker.number().numberBetween(0, 25))
                .interceptions(faker.number().numberBetween(0, 10))
                .forcedFumbles(faker.number().numberBetween(0, 8))
                .fumbleRecoveries(faker.number().numberBetween(0, 8))
                .passesDefended(faker.number().numberBetween(0, 30))

                // Special Teams
                .kickReturns(faker.number().numberBetween(0, 50))
                .kickReturnYards(faker.number().numberBetween(0, 1500))
                .puntReturns(faker.number().numberBetween(0, 50))
                .puntReturnYards(faker.number().numberBetween(0, 700))

                // General
                .fumbles(faker.number().numberBetween(0, 10))
                .gamesPlayed(gamesPlayed)
                .gamesStarted(gamesStarted)

                .build();
    }

    private double fakePasserRating() {
        return Math.round(
                faker.number().randomDouble(2, 50, 160) * 100.0
        ) / 100.0;
    }
}
