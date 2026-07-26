package com.domain.faker.nfl.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum GameStatus {

    SCHEDULED("Scheduled"),

    WARMUPS("Warmups"),

    IN_PROGRESS("In Progress"),

    HALFTIME("Halftime"),

    FINAL("Final"),

    OVERTIME("Overtime"),

    POSTPONED("Postponed"),

    CANCELLED("Cancelled");

    private final String displayName;
}
