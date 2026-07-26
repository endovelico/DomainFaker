package com.domain.faker.nfl.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum InjuryType {

    ANKLE("Ankle"),

    KNEE("Knee"),

    HAMSTRING("Hamstring"),

    GROIN("Groin"),

    SHOULDER("Shoulder"),

    ELBOW("Elbow"),

    WRIST("Wrist"),

    HAND("Hand"),

    FINGER("Finger"),

    HIP("Hip"),

    BACK("Back"),

    NECK("Neck"),

    FOOT("Foot"),

    CALF("Calf"),

    QUADRICEPS("Quadriceps"),

    CHEST("Chest"),

    RIB("Rib"),

    CONCUSSION("Concussion"),

    ILLNESS("Illness"),

    OTHER("Other");

    private final String displayName;
}
