package am.itspace.flashscore.service;

import am.itspace.flashscore.model.Team;

import java.util.List;

public interface TeamService {

    List<Team> getTeamsByLeague(int leagueName);
}
