package am.itspace.flashscore.service;

import am.itspace.flashscore.model.Player;
import am.itspace.flashscore.model.TeamPlayersIds;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

public interface TeamPlayersIdsService {
    List<TeamPlayersIds> findPlayerIdsByTeamId(int id);
}
