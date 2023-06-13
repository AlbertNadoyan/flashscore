package am.itspace.flashscore.service.impl;

import am.itspace.flashscore.model.Team;
import am.itspace.flashscore.repository.TeamRepository;
import am.itspace.flashscore.service.TeamService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeamServiceImpl implements TeamService {
    private final TeamRepository teamRepository;
    @Override
    public List<Team> getTeamsByLeague(int leagueName) {
        return teamRepository.findTeamsByLeague(leagueName);
    }
}
