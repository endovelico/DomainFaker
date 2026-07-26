package com.domain.faker.nfl.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Division {

    AFC_EAST(Conference.AFC, "AFC East"),
    AFC_NORTH(Conference.AFC, "AFC North"),
    AFC_SOUTH(Conference.AFC, "AFC South"),
    AFC_WEST(Conference.AFC, "AFC West"),

    NFC_EAST(Conference.NFC, "NFC East"),
    NFC_NORTH(Conference.NFC, "NFC North"),
    NFC_SOUTH(Conference.NFC, "NFC South"),
    NFC_WEST(Conference.NFC, "NFC West");

    private final Conference conference;

    private final String displayName;
}
