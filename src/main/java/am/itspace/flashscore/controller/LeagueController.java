package am.itspace.flashscore.controller;

import am.itspace.flashscore.model.League;
import am.itspace.flashscore.model.SportLeagueVideo;
import am.itspace.flashscore.model.Team;
import am.itspace.flashscore.service.LeagueService;
import am.itspace.flashscore.service.SportLeagueVideoService;
import am.itspace.flashscore.service.TeamService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class LeagueController {
    private final LeagueService leagueService;
    private final TeamService teamService;
    private final SportLeagueVideoService sportLeagueVideoService;

    @Value("${flashscore.spring.images.folder}")
    private String folderPathImages;

    @Value("${flashscore.spring.videos.folder}")
    private String folderPathVideos;

    @GetMapping("/leagues")
    public String leaguePage(ModelMap modelMap) {
        List<League> findAllLeague = leagueService.getAllLeague();
        modelMap.addAttribute("league", findAllLeague);
        return "league";
    }

    @GetMapping("/league/{teams}")
    public String teamsPage(@PathVariable int teams, ModelMap modelMap) {
        List<SportLeagueVideo> teamsAndVideosByLeague = sportLeagueVideoService.getTeamsAndVideosByLeague(teams);
        List<Team> findAllTeam = teamService.getTeamsByLeague(teams);
        modelMap.addAttribute("video", teamsAndVideosByLeague);
        modelMap.addAttribute("team", findAllTeam);
        return "teams";
    }

    @GetMapping("/leagues/getImage")
    public @ResponseBody byte[] getImage(@RequestParam("fileImage") String fileName) throws IOException {
        InputStream inputStream = new FileInputStream(folderPathImages + File.separator + fileName);
        return IOUtils.toByteArray(inputStream);
    }

    @GetMapping("/league/getVideo")
    public @ResponseBody byte[] getVideo(@RequestParam("leagueVideo") String fileName) throws IOException {
        InputStream inputStream = new FileInputStream(folderPathVideos + File.separator + fileName);
        return IOUtils.toByteArray(inputStream);
    }
}
