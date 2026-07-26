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
public class Injury {

    private UUID id;

    private InjuryType type;

    private InjuryStatus status;

    private LocalDate injuryDate;

    private LocalDate expectedReturnDate;

    private boolean seasonEnding;

    private String notes;

    private final Faker faker = new Faker();

    public Injury fakeInjury() {
        InjuryStatus status = fakeInjuryStatus();
        boolean seasonEnding = faker.bool().bool();

        LocalDate injuryDate = fakeInjuryDate();

        return Injury.builder()
                .id(UUID.randomUUID())
                .type(fakeInjuryType())
                .status(status)
                .injuryDate(injuryDate)
                .expectedReturnDate(
                        seasonEnding ? null : calculateReturnDate(injuryDate)
                )
                .seasonEnding(seasonEnding)
                .notes(faker.lorem().sentence())
                .build();
    }

    private InjuryType fakeInjuryType() {
        InjuryType[] types = InjuryType.values();

        return types[faker.number().numberBetween(0, types.length)];
    }

    private InjuryStatus fakeInjuryStatus() {
        InjuryStatus[] statuses = InjuryStatus.values();

        return statuses[faker.number().numberBetween(0, statuses.length)];
    }

    private LocalDate fakeInjuryDate() {
        return LocalDate.now()
                .minusDays(faker.number().numberBetween(1, 250));
    }

    private LocalDate calculateReturnDate(LocalDate injuryDate) {
        return injuryDate.plusDays(
                faker.number().numberBetween(7, 120)
        );
    }
}
