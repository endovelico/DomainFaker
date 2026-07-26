package com.domain.faker.nfl.service;

import com.domain.faker.nfl.model.DraftPick;
import com.domain.faker.nfl.model.Player;
import com.domain.faker.nfl.model.Season;
import com.domain.faker.nfl.model.Team;
import lombok.RequiredArgsConstructor;
import net.datafaker.Faker;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.IntStream;

@Service
@RequiredArgsConstructor
public class DraftService {

    private final DraftPick draftPickFaker = new DraftPick();
    private final Player playerFaker = new Player();
    private final Team teamFaker = new Team();
    private final Season seasonFaker = new Season();

    public List<DraftPick> getDraftBoard() {
        return IntStream.rangeClosed(1, 224)
                .mapToObj(i -> draftPickFaker.fakeDraftPick())
                .toList();
    }

    public List<DraftPick> getDraftBySeason(int year) {
        return IntStream.rangeClosed(1, 224)
                .mapToObj(i -> {
                    DraftPick pick = draftPickFaker.fakeDraftPick();
                    pick.setYear(year);
                    return pick;
                })
                .toList();
    }

    public DraftPick getOverallPick(int overallPick) {
        DraftPick pick = draftPickFaker.fakeDraftPick();
        pick.setOverallPick(overallPick);
        return pick;
    }

    public List<Player> getTopProspects() {
        return IntStream.range(0, 100)
                .mapToObj(i -> playerFaker.fakePlayer())
                .toList();
    }

    public List<Player> getAvailableProspects() {
        return IntStream.range(0, 50)
                .mapToObj(i -> playerFaker.fakePlayer())
                .toList();
    }

    public List<Team> getDraftOrder() {
        return IntStream.range(0, 32)
                .mapToObj(i -> teamFaker.fakeTeam())
                .toList();
    }

    public Season getCurrentDraftSeason() {
        return seasonFaker.fakeSeason();
    }

    public DraftPick simulatePick(int overallPick) {
        DraftPick pick = draftPickFaker.fakeDraftPick();
        pick.setOverallPick(overallPick);
        pick.setPlayer(playerFaker.fakePlayer());
        return pick;
    }

    public List<DraftPick> simulateRound(int round) {
        return IntStream.rangeClosed(1, 32)
                .mapToObj(i -> {
                    DraftPick pick = draftPickFaker.fakeDraftPick();
                    pick.setRound(round);
                    pick.setOverallPick((round - 1) * 32 + i);
                    return pick;
                })
                .toList();
    }

    public List<DraftPick> simulateEntireDraft() {
        return IntStream.rangeClosed(1, 224)
                .mapToObj(i -> {
                    DraftPick pick = draftPickFaker.fakeDraftPick();
                    pick.setOverallPick(i);
                    pick.setRound(((i - 1) / 32) + 1);
                    return pick;
                })
                .toList();
    }
}
