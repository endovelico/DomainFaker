package com.domain.faker.nfl.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum CoachRole {

    HEAD_COACH("Head Coach"),

    OFFENSIVE_COORDINATOR("Offensive Coordinator"),

    DEFENSIVE_COORDINATOR("Defensive Coordinator"),

    SPECIAL_TEAMS_COORDINATOR("Special Teams Coordinator"),

    QUARTERBACKS_COACH("Quarterbacks Coach"),

    RUNNING_BACKS_COACH("Running Backs Coach"),

    WIDE_RECEIVERS_COACH("Wide Receivers Coach"),

    TIGHT_ENDS_COACH("Tight Ends Coach"),

    OFFENSIVE_LINE_COACH("Offensive Line Coach"),

    DEFENSIVE_LINE_COACH("Defensive Line Coach"),

    LINEBACKERS_COACH("Linebackers Coach"),

    DEFENSIVE_BACKS_COACH("Defensive Backs Coach"),

    STRENGTH_AND_CONDITIONING("Strength & Conditioning Coach"),

    ASSISTANT_HEAD_COACH("Assistant Head Coach");

    private final String displayName;
}
