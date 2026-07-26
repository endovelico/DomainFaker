package com.domain.faker.nfl.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Conference {

    AFC("American Football Conference"),

    NFC("National Football Conference");

    private final String displayName;
}
