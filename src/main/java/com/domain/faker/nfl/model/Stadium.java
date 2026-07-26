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
@ToString
@EqualsAndHashCode(of = "id")
public class Stadium {

    private UUID id;

    private String name;

    private String city;

    private String state;

    private int capacity;

    private boolean indoor;

    private int yearOpened;

    private Team homeTeam;

    private final Faker faker = new Faker();

    public Stadium fakeStadium() {
        return Stadium.builder()
                .id(UUID.randomUUID())
                .name(fakeStadiumName())
                .city(faker.address().city())
                .state(faker.address().stateAbbr())
                .capacity(faker.number().numberBetween(50_000, 90_000))
                .indoor(faker.bool().bool())
                .yearOpened(faker.number().numberBetween(1950, 2025))
                .homeTeam(homeTeam.fakeTeam())
                .build();
    }

    private String fakeStadiumName() {
        return faker.options().option(
                "Memorial Stadium",
                "National Stadium",
                "Victory Field",
                "Champions Stadium",
                "Liberty Stadium",
                "Riverfront Stadium",
                "Metropolitan Stadium"
        );
    }
}
