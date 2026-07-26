package com.domain.faker.nfl.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.datafaker.Faker;

import java.time.LocalDate;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DraftPick {

    private UUID id;

    private int round;

    private int overallPick;

    private Player player;

    private Team team;

    private int year;

    private String college;

    private final Faker faker = new Faker();

    public DraftPick fakeDraftPick() {
        return DraftPick.builder()
                .id(UUID.randomUUID())
                .year(LocalDate.now().getYear())
                .round(faker.number().numberBetween(1, 8))
                .overallPick(faker.number().numberBetween(1, 257))
                .team(team.fakeTeam())
                .player(player.fakePlayer())
                .build();
    }
}
