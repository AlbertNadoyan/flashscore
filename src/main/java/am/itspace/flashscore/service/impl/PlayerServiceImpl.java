package am.itspace.flashscore.service.impl;

import am.itspace.flashscore.model.Player;
import am.itspace.flashscore.repository.PlayerRepository;
import am.itspace.flashscore.repository.TeamRepository;
import am.itspace.flashscore.service.PlayerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PlayerServiceImpl implements PlayerService {
    private final PlayerRepository playerRepository;
    @Override
    public List<Player> findPlayersByTeamId(int teamId) {
        return playerRepository.findPlayersByTeamId(teamId);
    }
}
