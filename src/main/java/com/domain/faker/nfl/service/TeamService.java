package com.domain.faker.nfl.service;

import com.domain.faker.nfl.model.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.IntStream;

@Service
@RequiredArgsConstructor
public class TeamService {

    private final Team teamFaker = new Team();
    private final Player playerFaker = new Player();
    private final Coach coachFaker = new Coach();
    private final Standing standingFaker = new Standing();
    public final Game gameFaker = new Game();

    public List<Team> getTeams() {
        return IntStream.range(0, 32)
                .mapToObj(i -> teamFaker.fakeTeam())
                .toList();
    }

    public Team getTeam(UUID teamId) {
        Team team = teamFaker.fakeTeam();
        team.setId(teamId);
        return team;
    }

    public List<Team> getTeamsByConference(Conference conference) {
        return IntStream.range(0, 16)
                .mapToObj(i -> {
                    Team team = teamFaker.fakeTeam();
                    team.setConference(conference);
                    return team;
                })
                .toList();
    }

    public List<Team> getTeamsByDivision(Division division) {
        return IntStream.range(0, 4)
                .mapToObj(i -> {
                    Team team = teamFaker.fakeTeam();
                    team.setDivision(division);
                    return team;
                })
                .toList();
    }

    public List<Player> getRoster(UUID teamId) {
        Team team = teamFaker.fakeTeam();
        team.setId(teamId);

        return IntStream.range(0, 53)
                .mapToObj(i -> {
                    Player player = playerFaker.fakePlayer();
                    player.setTeam(team);
                    return player;
                })
                .toList();
    }

    public Coach getHeadCoach(UUID teamId) {
        Coach coach = coachFaker.fakeCoach();
        coach.getTeam().setId(teamId);
        return coach;
    }

    public Stadium getHomeStadium(UUID teamId) {
        Stadium stadium = new Stadium().fakeStadium();
        stadium.getHomeTeam().setId(teamId);
        return stadium;
    }

    public Standing getStanding(UUID teamId) {
        Standing standing = standingFaker.fakeStanding();
        standing.getTeam().setId(teamId);
        return standing;
    }

    public List<Game> getSchedule(UUID teamId) {
        Team team = teamFaker.fakeTeam();
        team.setId(teamId);

        return IntStream.range(0, 17)
                .mapToObj(i -> {
                    Game game = gameFaker.fakeGame();

                    if (i % 2 == 0) {
                        game.setHomeTeam(team);
                    } else {
                        game.setAwayTeam(team);
                    }

                    return game;
                })
                .toList();
    }
}
