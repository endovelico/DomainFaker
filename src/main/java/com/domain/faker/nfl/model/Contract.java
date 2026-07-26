package com.domain.faker.nfl.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import net.datafaker.Faker;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Contract {

    private UUID id;

    private LocalDate startDate;

    private LocalDate endDate;

    private BigDecimal totalValue;

    private BigDecimal guaranteedMoney;

    private BigDecimal annualSalary;

    private BigDecimal signingBonus;

    private boolean active;

    private final Faker faker = new Faker();

    public Contract fakeContract() {
        int startYear = faker.number().numberBetween(2023, 2026);
        int durationYears = faker.number().numberBetween(1, 6);

        LocalDate startDate = LocalDate.of(startYear, 3, 1);
        LocalDate endDate = startDate.plusYears(durationYears);

        BigDecimal annualSalary = randomMoney(500_000, 50_000_000);
        BigDecimal totalValue = annualSalary.multiply(
                BigDecimal.valueOf(durationYears)
        );

        BigDecimal guaranteedMoney = randomMoney(
                annualSalary.intValue(),
                totalValue.intValue()
        );

        return Contract.builder()
                .id(UUID.randomUUID())
                .startDate(startDate)
                .endDate(endDate)
                .totalValue(totalValue)
                .guaranteedMoney(guaranteedMoney)
                .annualSalary(annualSalary)
                .signingBonus(randomMoney(50_000, 10_000_000))
                .active(endDate.isAfter(LocalDate.now()))
                .build();
    }

    private BigDecimal randomMoney(int min, int max) {
        return BigDecimal.valueOf(
                faker.number().numberBetween(min, max)
        );
    }
}
