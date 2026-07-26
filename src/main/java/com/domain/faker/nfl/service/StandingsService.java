package com.domain.faker.nfl.service;

import com.domain.faker.nfl.model.Conference;
import com.domain.faker.nfl.model.Division;
import com.domain.faker.nfl.model.Standing;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.IntStream;

@Service
@RequiredArgsConstructor
public class StandingsService {

    private final Standing standingFaker = new Standing();

    public List<Standing> getStandings() {
        return IntStream.range(0, 32)
                .mapToObj(i -> standingFaker.fakeStanding())
                .toList();
    }

    public List<Standing> getStandings(int seasonYear) {
        return IntStream.range(0, 32)
                .mapToObj(i -> {
                    Standing standing = standingFaker.fakeStanding();
                    standing.getSeason().setYear(seasonYear);
                    return standing;
                })
                .toList();
    }

    public List<Standing> getConferenceStandings(int seasonYear, Conference conference) {
        return IntStream.range(0, 16)
                .mapToObj(i -> {
                    Standing standing = standingFaker.fakeStanding();
                    standing.getSeason().setYear(seasonYear);
                    standing.getTeam().setConference(conference);
                    return standing;
                })
                .toList();
    }

    public List<Standing> getDivisionStandings(int seasonYear, Division division) {
        return IntStream.range(0, 4)
                .mapToObj(i -> {
                    Standing standing = standingFaker.fakeStanding();
                    standing.getSeason().setYear(seasonYear);
                    standing.setDivision(division);
                    standing.getTeam().setDivision(division);
                    standing.setRank(i + 1);
                    return standing;
                })
                .toList();
    }

    public Standing getTeamStanding(UUID teamId) {
        Standing standing = standingFaker.fakeStanding();
        standing.getTeam().setId(teamId);
        return standing;
    }

    public List<Standing> getPlayoffPicture(int seasonYear) {
        return IntStream.range(0, 14)
                .mapToObj(i -> {
                    Standing standing = standingFaker.fakeStanding();
                    standing.getSeason().setYear(seasonYear);
                    standing.setRank((i % 7) + 1);
                    return standing;
                })
                .toList();
    }

    public List<Standing> getWildcardStandings(int seasonYear, Conference conference) {
        return IntStream.range(0, 7)
                .mapToObj(i -> {
                    Standing standing = standingFaker.fakeStanding();
                    standing.getSeason().setYear(seasonYear);
                    standing.getTeam().setConference(conference);
                    return standing;
                })
                .toList();
    }

    public List<Standing> getPowerRankings() {
        return IntStream.range(0, 32)
                .mapToObj(i -> {
                    Standing standing = standingFaker.fakeStanding();
                    standing.setRank(i + 1);
                    return standing;
                })
                .toList();
    }
}
