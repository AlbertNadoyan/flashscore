package am.itspace.flashscore.service.impl;

import am.itspace.flashscore.model.Player;
import am.itspace.flashscore.model.TeamPlayersIds;
import am.itspace.flashscore.repository.TeamPlayerIdsRepository;
import am.itspace.flashscore.service.TeamPlayersIdsService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeamPlayersIdsServiceImpl implements TeamPlayersIdsService {
    private final TeamPlayerIdsRepository teamPlayerIdsRepository;

    @Override
    public List<TeamPlayersIds> findPlayerIdsByTeamId(int id) {
        return teamPlayerIdsRepository.findPlayerIdsByTeamId(id);
    }
}
