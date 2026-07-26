package com.domain.faker.nfl.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum InjuryStatus {

    ACTIVE("Active"),

    PROBABLE("Probable"),

    QUESTIONABLE("Questionable"),

    DOUBTFUL("Doubtful"),

    OUT("Out"),

    INJURED_RESERVE("Injured Reserve"),

    PHYSICALLY_UNABLE_TO_PERFORM("Physically Unable To Perform"),

    NON_FOOTBALL_INJURY("Non-Football Injury");

    private final String displayName;
}
