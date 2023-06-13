package am.itspace.flashscore.service;

import am.itspace.flashscore.model.TeamPlayerInfo;

import java.util.Map;
import java.util.Set;

public interface ScraperService {
    void extractDataFromWebSite();
    void saveDataToDatabase(Map<String, String> teamPlayerInfo);
}
