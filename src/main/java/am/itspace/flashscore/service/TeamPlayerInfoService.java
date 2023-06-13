package am.itspace.flashscore.service;

import am.itspace.flashscore.model.Team;
import am.itspace.flashscore.model.TeamPlayerInfo;

import java.util.List;
import java.util.Optional;

public interface TeamPlayerInfoService {
    List<Team> findById(int teamId);
}
