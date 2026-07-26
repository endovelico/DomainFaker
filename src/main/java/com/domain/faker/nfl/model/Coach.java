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
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Coach {

    private UUID id;

    private String firstName;

    private String lastName;

    private CoachRole role;

    private LocalDate dateOfBirth;

    private int yearsExperience;

    private Team team;

    private final Faker faker = new Faker();

    public Coach fakeCoach() {
        return Coach.builder()
                .id(UUID.randomUUID())
                .firstName(faker.name().firstName())
                .lastName(faker.name().lastName())
                .role(fakeCoachRole())
                .dateOfBirth(fakeDateOfBirth())
                .yearsExperience(faker.number().numberBetween(1, 40))
                .team(team.fakeTeam())
                .build();
    }

    private CoachRole fakeCoachRole() {
        CoachRole[] roles = CoachRole.values();
        return roles[faker.number().numberBetween(0, roles.length)];
    }

    private LocalDate fakeDateOfBirth() {
        int year = faker.number().numberBetween(1950, 1990);
        int month = faker.number().numberBetween(1, 13);
        int day = faker.number().numberBetween(1, 28);

        return LocalDate.of(year, month, day);
    }
}
