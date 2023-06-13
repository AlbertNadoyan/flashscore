package am.itspace.flashscore.controller;

import am.itspace.flashscore.model.Player;
import am.itspace.flashscore.model.Team;
import am.itspace.flashscore.model.TeamPlayerInfo;
import am.itspace.flashscore.model.TeamPlayersIds;
import am.itspace.flashscore.service.PlayerService;
import am.itspace.flashscore.service.TeamPlayerInfoService;
import am.itspace.flashscore.service.TeamPlayersIdsService;
import am.itspace.flashscore.service.TeamService;
import jakarta.annotation.PostConstruct;
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
public class TeamController {
    private final TeamPlayerInfoService teamPlayerInfoService;
    private final PlayerService playerService;
    private final TeamPlayersIdsService teamPlayersIdsService;

    @Value("${flashscore.spring.images.folder}")
    private String folderPathImages;

    @GetMapping("/team/{id}")
    public String currentTeamPage(@PathVariable int id, ModelMap modelMap){
        List<Team> findAllTeam = teamPlayerInfoService.findById(id);
        List<TeamPlayersIds> findPlayer = teamPlayersIdsService.findPlayerIdsByTeamId(id);
        modelMap.addAttribute("team", findAllTeam);
        modelMap.addAttribute("player", findPlayer);
        return "currentTeam";
    }
    @GetMapping("/player/getImage")
    public @ResponseBody byte[] getImage(@RequestParam("fileImage") String fileName) throws IOException {
        InputStream inputStream = new FileInputStream(folderPathImages + File.separator + fileName);
        return IOUtils.toByteArray(inputStream);
    }
}
