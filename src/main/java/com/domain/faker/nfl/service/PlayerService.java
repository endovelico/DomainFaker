package com.domain.faker.nfl.service;

import com.domain.faker.nfl.model.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.IntStream;

@Service
@RequiredArgsConstructor
public class PlayerService {

    private final Player player = new Player();
    private final Team team = new Team();
    private final Contract contract = new Contract();
    private final Injury injury = new Injury();
    private final PlayerStatistics statistics = new PlayerStatistics();

    public List<Player> getPlayers() {
        return IntStream.range(0, 250)
                .mapToObj(i -> player.fakePlayer())
                .toList();
    }

    public Contract getContract(UUID playerId) {
        return contract.fakeContract();
    }

    public Injury getInjury(UUID playerId) {
        return injury.fakeInjury();
    }

    public PlayerStatistics getStatistics(UUID playerId) {
        return statistics.fakePlayerStatistics();
    }

    public List<Player> getTopPlayers() {
        return IntStream.range(0, 20)
                .mapToObj(i -> player.fakePlayer())
                .toList();
    }
}
