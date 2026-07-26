package com.domain.faker.nfl.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import net.datafaker.Faker;

import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"team", "season"})
@EqualsAndHashCode(of = "id")
public class Standing {

    private UUID id;

    private Season season;

    private Team team;

    private Division division;

    private int rank;

    private int wins;

    private int losses;

    private int ties;

    private int gamesPlayed;

    private int pointsFor;

    private int pointsAgainst;

    private int pointDifferential;

    private int divisionWins;

    private int divisionLosses;

    private int conferenceWins;

    private int conferenceLosses;

    private int homeWins;

    private int homeLosses;

    private int awayWins;

    private int awayLosses;

    private double winPercentage;

    private final Faker faker = new Faker();


    public Standing fakeStanding() {

        int wins = faker.number().numberBetween(0, 18);
        int losses = faker.number().numberBetween(0, 18 - wins);
        int ties = faker.number().numberBetween(0, 1);

        int gamesPlayed = wins + losses + ties;

        int pointsFor = faker.number().numberBetween(150, 550);
        int pointsAgainst = faker.number().numberBetween(150, 550);

        int homeWins = faker.number().numberBetween(0, wins + 1);
        int awayWins = wins - homeWins;

        int homeLosses = faker.number().numberBetween(0, losses + 1);
        int awayLosses = losses - homeLosses;

        return Standing.builder()
                .id(UUID.randomUUID())
                .season(season.fakeSeason())
                .team(team.fakeTeam())
                .division(fakeDivision())

                .rank(faker.number().numberBetween(1, 5))

                .wins(wins)
                .losses(losses)
                .ties(ties)
                .gamesPlayed(gamesPlayed)

                .pointsFor(pointsFor)
                .pointsAgainst(pointsAgainst)
                .pointDifferential(pointsFor - pointsAgainst)

                .divisionWins(faker.number().numberBetween(0, Math.min(wins, 6) + 1))
                .divisionLosses(faker.number().numberBetween(0, Math.min(losses, 6) + 1))

                .conferenceWins(faker.number().numberBetween(0, Math.min(wins, 12) + 1))
                .conferenceLosses(faker.number().numberBetween(0, Math.min(losses, 12) + 1))

                .homeWins(homeWins)
                .homeLosses(homeLosses)

                .awayWins(awayWins)
                .awayLosses(awayLosses)

                .winPercentage(calculateWinPercentage(wins, losses, ties))
                .build();
    }

    private double calculateWinPercentage(int wins, int losses, int ties) {
        int games = wins + losses + ties;

        if (games == 0) {
            return 0.0;
        }

        return Math.round(
                ((wins + (ties * 0.5)) / games) * 1000.0
        ) / 1000.0;
    }

    private Division fakeDivision() {
        Division[] divisions = Division.values();

        return divisions[
                faker.number().numberBetween(0, divisions.length)
                ];
    }
}
