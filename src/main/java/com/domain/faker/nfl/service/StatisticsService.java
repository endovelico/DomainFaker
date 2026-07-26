package com.domain.faker.nfl.service;

import com.domain.faker.nfl.model.Game;
import com.domain.faker.nfl.model.GameStatistics;
import com.domain.faker.nfl.model.Player;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StatisticsService {

    private final Player playerStatisticsFaker = new Player();
    private final GameStatistics gameStatisticsFaker = new GameStatistics();
    private final Player playerFaker = new Player();

    public PlayerStatistics getPlayerStatistics(UUID playerId) {
        return playerStatisticsFaker.fakePlayerStatistics();
    }

    public GameStatistics getGameStatistics(UUID gameId) {
        return gameStatisticsFaker.fakeGameStatistics();
    }

    public List<Player> getPassingLeaders() {
        return IntStream.range(0, 25)
                .mapToObj(i -> playerFaker.fakePlayer())
                .peek(player -> player.setStatistics(playerStatisticsFaker.fakePlayerStatistics()))
                .toList();
    }

    public List<Player> getRushingLeaders() {
        return IntStream.range(0, 25)
                .mapToObj(i -> playerFaker.fakePlayer())
                .peek(player -> player.setStatistics(playerStatisticsFaker.fakePlayerStatistics()))
                .toList();
    }

    public List<Player> getReceivingLeaders() {
        return IntStream.range(0, 25)
                .mapToObj(i -> playerFaker.fakePlayer())
                .peek(player -> player.setStatistics(playerStatisticsFaker.fakePlayerStatistics()))
                .toList();
    }

    public List<Player> getTackleLeaders() {
        return IntStream.range(0, 25)
                .mapToObj(i -> playerFaker.fakePlayer())
                .peek(player -> player.setStatistics(playerStatisticsFaker.fakePlayerStatistics()))
                .toList();
    }

    public List<Player> getSackLeaders() {
        return IntStream.range(0, 25)
                .mapToObj(i -> playerFaker.fakePlayer())
                .peek(player -> player.setStatistics(playerStatisticsFaker.fakePlayerStatistics()))
                .toList();
    }

    public List<Player> getInterceptionLeaders() {
        return IntStream.range(0, 25)
                .mapToObj(i -> playerFaker.fakePlayer())
                .peek(player -> player.setStatistics(playerStatisticsFaker.fakePlayerStatistics()))
                .toList();
    }

    public List<Player> getTouchdownLeaders() {
        return IntStream.range(0, 25)
                .mapToObj(i -> playerFaker.fakePlayer())
                .peek(player -> player.setStatistics(playerStatisticsFaker.fakePlayerStatistics()))
                .toList();
    }

    public List<Player> getTopPlayers() {
        return IntStream.range(0, 100)
                .mapToObj(i -> playerFaker.fakePlayer())
                .toList();
    }
}
