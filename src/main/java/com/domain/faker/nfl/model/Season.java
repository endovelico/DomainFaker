package com.domain.faker.nfl.model;

import lombok.*;
import net.datafaker.Faker;
import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(of = "id")
public class Season {

    private UUID id;

    /**
     * The season year (e.g. 2025 for the 2025 NFL season).
     */
    private int year;

    /**
     * Regular season start date.
     */
    private LocalDate startDate;

    /**
     * Super Bowl date / official end of season.
     */
    private LocalDate endDate;

    /**
     * Total number of regular season weeks.
     */
    private int regularSeasonWeeks;

    /**
     * Whether this is the currently active season.
     */
    private boolean current;

    /**
     * Super Bowl champion.
     */
    private Team champion;

    private final Faker faker = new Faker();

    public Season fakeSeason() {
        int year = faker.number().numberBetween(2000, 2026);

        return Season.builder()
                .id(UUID.randomUUID())
                .year(year)
                .startDate(LocalDate.of(year, 9, 1))
                .endDate(LocalDate.of(year + 1, 2, 15))
                .regularSeasonWeeks(18)
                .current(year == 2025)
                .champion(null) // Set a fake Team if needed
                .build();
    }
}
