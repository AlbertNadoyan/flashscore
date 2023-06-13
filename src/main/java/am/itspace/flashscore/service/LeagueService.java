package am.itspace.flashscore.service;

import am.itspace.flashscore.model.League;
import am.itspace.flashscore.model.SportLeagueVideo;

import java.util.List;

public interface LeagueService {
    List<League> getAllLeague();

    List<League> getFiveLeague();

    List<League> getUefaLeagues();

}
