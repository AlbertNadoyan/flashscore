package am.itspace.flashscore.service.impl;

import am.itspace.flashscore.model.Team;
import am.itspace.flashscore.model.TeamPlayerInfo;
import am.itspace.flashscore.repository.TeamPlayerInfoRepository;
import am.itspace.flashscore.repository.TeamRepository;
import am.itspace.flashscore.service.TeamPlayerInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TeamPlayerInfoServiceImpl implements TeamPlayerInfoService {
    private final TeamPlayerInfoRepository teamPlayerInfoRepository;
    private final TeamRepository teamRepository;

    @Override
    public List<Team> findById(int teamId) {
        return teamRepository.findById(teamId);
    }

}
