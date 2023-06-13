package am.itspace.flashscore.service;

import am.itspace.flashscore.model.League;
import am.itspace.flashscore.model.SportLeagueVideo;

import java.util.List;
import java.util.Optional;

public interface SportLeagueVideoService {
    List<SportLeagueVideo> getTeamsAndVideosByLeague(int leagueName);
}
