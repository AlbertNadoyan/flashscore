package am.itspace.flashscore.service.impl;

import am.itspace.flashscore.model.League;
import am.itspace.flashscore.model.SportLeagueVideo;
import am.itspace.flashscore.model.enums.Country;
import am.itspace.flashscore.repository.SportLeagueVideoRepository;
import am.itspace.flashscore.service.SportLeagueVideoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SportLeagueVideoServiceImpl implements SportLeagueVideoService {
    private final SportLeagueVideoRepository sportLeagueVideoRepository;
    public List<SportLeagueVideo> getTeamsAndVideosByLeague(int leagueName) {
        return  sportLeagueVideoRepository.findLeagueAndVideoById(leagueName);
    }
}
