package am.itspace.flashscore.service;

import am.itspace.flashscore.model.Player;

import java.util.List;

public interface PlayerService {
    List<Player> findPlayersByTeamId(int teamId);
}
