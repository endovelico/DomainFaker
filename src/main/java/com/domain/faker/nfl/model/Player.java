package com.domain.faker.nfl.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import net.datafaker.Faker;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"team"})
@EqualsAndHashCode(of = "id")
public class Player {

    private UUID id;

    private String firstName;

    private String lastName;

    private int jerseyNumber;

    private Position position;

    private LocalDate dateOfBirth;

    private int heightInches;

    private int weightPounds;

    private int yearsExperience;

    private Team team;

    private Contract contract;

    private Injury injury;

    private PlayerStatistics statistics;

    private List<String> awards;

    private boolean active;

    private final Faker faker = new Faker();

    public Player fakePlayer() {
        LocalDate dateOfBirth = fakeDateOfBirth();
        int experience = calculateExperience(dateOfBirth);

        return Player.builder()
                .id(UUID.randomUUID())
                .firstName(faker.name().firstName())
                .lastName(faker.name().lastName())
                .jerseyNumber(faker.number().numberBetween(1, 99))
                .position(fakePosition())
                .dateOfBirth(dateOfBirth)
                .heightInches(faker.number().numberBetween(65, 80))
                .weightPounds(faker.number().numberBetween(180, 340))
                .yearsExperience(experience)
                .team(team.fakeTeam())
                .contract(contract.fakeContract())
                .injury(fakeInjury())
                .statistics(statistics.fakePlayerStatistics())
                .awards(fakeAwards())
                .active(faker.bool().bool())
                .build();
    }

    private Position fakePosition() {
        Position[] positions = Position.values();

        return positions[faker.number().numberBetween(0, positions.length)];
    }

    private LocalDate fakeDateOfBirth() {
        return LocalDate.now()
                .minusYears(faker.number().numberBetween(20, 40))
                .minusDays(faker.number().numberBetween(0, 365));
    }

    private int calculateExperience(LocalDate dateOfBirth) {
        int age = LocalDate.now().getYear() - dateOfBirth.getYear();

        return faker.number().numberBetween(
                0,
                Math.max(age - 18, 1)
        );
    }

    private Injury fakeInjury() {
        // Most players are healthy
        return faker.number().numberBetween(1, 10) <= 3
                ? injury.fakeInjury()
                : null;
    }

    private List<String> fakeAwards() {
        return faker.options().option(
                List.of(
                        "Pro Bowl",
                        "All-Pro",
                        "Rookie of the Year",
                        "MVP",
                        "Super Bowl Champion"
                ),
                List.of(),
                List.of("Pro Bowl"),
                List.of("All-Pro", "Pro Bowl")
        );
    }
}
