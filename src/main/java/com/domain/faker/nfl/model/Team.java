package com.domain.faker.nfl.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import net.datafaker.Faker;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"roster", "headCoach", "stadium"})
@EqualsAndHashCode(of = "id")
public class Team {

    private UUID id;

    private String city;

    private String name;

    private String abbreviation;

    private Conference conference;

    private Division division;

    private Stadium stadium;

    private Coach headCoach;

    private List<Player> roster;

    private String primaryColor;

    private String secondaryColor;

    private boolean active;

    private final Faker faker = new Faker();

    public Team fakeTeam() {
        return Team.builder()
                .id(UUID.randomUUID())
                .city(faker.address().city())
                .name(fakeTeamName())
                .abbreviation(fakeAbbreviation())
                .conference(fakeConference())
                .division(fakeDivision())
                .stadium(null)
                .headCoach(null)
                .roster(new ArrayList<>())
                .primaryColor(fakeColor())
                .secondaryColor(fakeColor())
                .active(true)
                .build();
    }

    private String fakeTeamName() {
        return faker.options().option(
                "Warriors",
                "Titans",
                "Eagles",
                "Knights",
                "Sharks",
                "Panthers",
                "Lions",
                "Bulls",
                "Falcons",
                "Ravens"
        );
    }

    private String fakeAbbreviation() {
        return faker.options().option(
                "ATL",
                "DAL",
                "NYG",
                "KC",
                "BUF",
                "SF",
                "MIA",
                "CHI",
                "SEA",
                "DEN"
        );
    }

    private Conference fakeConference() {
        Conference[] conferences = Conference.values();

        return conferences[
                faker.number().numberBetween(0, conferences.length)
                ];
    }

    private Division fakeDivision() {
        Division[] divisions = Division.values();

        return divisions[
                faker.number().numberBetween(0, divisions.length)
                ];
    }

    private String fakeColor() {
        return faker.color().name();
    }
}
