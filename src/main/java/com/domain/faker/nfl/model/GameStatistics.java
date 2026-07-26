package com.domain.faker.nfl.model;

import lombok.*;
import net.datafaker.Faker;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class GameStatistics {

    private int homeFirstDowns;
    private int awayFirstDowns;

    private int homeTotalYards;
    private int awayTotalYards;

    private int homePassingYards;
    private int awayPassingYards;

    private int homeRushingYards;
    private int awayRushingYards;

    private int homeTurnovers;
    private int awayTurnovers;

    private int homePenalties;
    private int awayPenalties;

    private int homePenaltyYards;
    private int awayPenaltyYards;

    private int homeTimeOfPossessionSeconds;
    private int awayTimeOfPossessionSeconds;

    private int homeThirdDownConversions;
    private int homeThirdDownAttempts;

    private int awayThirdDownConversions;
    private int awayThirdDownAttempts;

    private int homeFourthDownConversions;
    private int homeFourthDownAttempts;

    private int awayFourthDownConversions;
    private int awayFourthDownAttempts;

    private int homeRedZoneConversions;
    private int homeRedZoneAttempts;

    private int awayRedZoneConversions;
    private int awayRedZoneAttempts;

    private final Faker faker = new Faker();

    public GameStatistics fakeGameStatistics() {
        int homeThirdDownAttempts = faker.number().numberBetween(5, 18);
        int awayThirdDownAttempts = faker.number().numberBetween(5, 18);

        int homeFourthDownAttempts = faker.number().numberBetween(0, 5);
        int awayFourthDownAttempts = faker.number().numberBetween(0, 5);

        int homeRedZoneAttempts = faker.number().numberBetween(1, 6);
        int awayRedZoneAttempts = faker.number().numberBetween(1, 6);

        return GameStatistics.builder()
                .homeFirstDowns(faker.number().numberBetween(10, 30))
                .awayFirstDowns(faker.number().numberBetween(10, 30))

                .homeTotalYards(faker.number().numberBetween(200, 550))
                .awayTotalYards(faker.number().numberBetween(200, 550))

                .homePassingYards(faker.number().numberBetween(100, 400))
                .awayPassingYards(faker.number().numberBetween(100, 400))

                .homeRushingYards(faker.number().numberBetween(20, 250))
                .awayRushingYards(faker.number().numberBetween(20, 250))

                .homeTurnovers(faker.number().numberBetween(0, 4))
                .awayTurnovers(faker.number().numberBetween(0, 4))

                .homePenalties(faker.number().numberBetween(2, 12))
                .awayPenalties(faker.number().numberBetween(2, 12))

                .homePenaltyYards(faker.number().numberBetween(10, 150))
                .awayPenaltyYards(faker.number().numberBetween(10, 150))

                // 20-40 minutes of possession
                .homeTimeOfPossessionSeconds(
                        faker.number().numberBetween(1200, 2400)
                )
                .awayTimeOfPossessionSeconds(
                        faker.number().numberBetween(1200, 2400)
                )

                .homeThirdDownConversions(
                        faker.number().numberBetween(1, homeThirdDownAttempts)
                )
                .homeThirdDownAttempts(homeThirdDownAttempts)

                .awayThirdDownConversions(
                        faker.number().numberBetween(1, awayThirdDownAttempts)
                )
                .awayThirdDownAttempts(awayThirdDownAttempts)

                .homeFourthDownConversions(
                        faker.number().numberBetween(0, homeFourthDownAttempts + 1)
                )
                .homeFourthDownAttempts(homeFourthDownAttempts)

                .awayFourthDownConversions(
                        faker.number().numberBetween(0, awayFourthDownAttempts + 1)
                )
                .awayFourthDownAttempts(awayFourthDownAttempts)

                .homeRedZoneConversions(
                        faker.number().numberBetween(0, homeRedZoneAttempts + 1)
                )
                .homeRedZoneAttempts(homeRedZoneAttempts)

                .awayRedZoneConversions(
                        faker.number().numberBetween(0, awayRedZoneAttempts + 1)
                )
                .awayRedZoneAttempts(awayRedZoneAttempts)

                .build();
    }
}
