package am.itspace.flashscore.service.impl;

import am.itspace.flashscore.model.League;
import am.itspace.flashscore.model.SportLeagueVideo;
import am.itspace.flashscore.repository.LeagueRepository;
import am.itspace.flashscore.repository.SportLeagueVideoRepository;
import am.itspace.flashscore.service.LeagueService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LeagueServiceImpl implements LeagueService {
    private final LeagueRepository leagueRepository;
    @Override
    public List<League> getAllLeague() {
        return leagueRepository.findAll();
    }

    @Override
    public List<League> getFiveLeague() {
        return leagueRepository.findTop5ByOrderById();
    }
    @Override
    public List<League> getUefaLeagues() {
        return leagueRepository.findByLeaguesContaining();
    }

}
