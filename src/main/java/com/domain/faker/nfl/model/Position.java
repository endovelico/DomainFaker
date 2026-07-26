package com.domain.faker.nfl.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Position {

    // Offense
    QB("QB", "Quarterback"),
    RB("RB", "Running Back"),
    FB("FB", "Fullback"),
    WR("WR", "Wide Receiver"),
    TE("TE", "Tight End"),
    LT("LT", "Left Tackle"),
    LG("LG", "Left Guard"),
    C("C", "Center"),
    RG("RG", "Right Guard"),
    RT("RT", "Right Tackle"),

    // Defense
    DE("DE", "Defensive End"),
    DT("DT", "Defensive Tackle"),
    NT("NT", "Nose Tackle"),
    OLB("OLB", "Outside Linebacker"),
    MLB("MLB", "Middle Linebacker"),
    ILB("ILB", "Inside Linebacker"),
    CB("CB", "Cornerback"),
    FS("FS", "Free Safety"),
    SS("SS", "Strong Safety"),

    // Special Teams
    K("K", "Kicker"),
    P("P", "Punter"),
    LS("LS", "Long Snapper");

    private final String abbreviation;

    private final String displayName;
}
