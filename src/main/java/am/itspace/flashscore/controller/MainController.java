package am.itspace.flashscore.controller;

import am.itspace.flashscore.model.League;
import am.itspace.flashscore.model.News;
import am.itspace.flashscore.model.Sport;
import am.itspace.flashscore.service.LeagueService;
import am.itspace.flashscore.service.NewsService;
import am.itspace.flashscore.service.ScraperService;
import am.itspace.flashscore.service.SportService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.*;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class MainController {
    private final ScraperService scraperService;
    private final SportService sportService;
    private final LeagueService leagueService;
    private final NewsService newsService;

    @Value("${flashscore.spring.images.folder}")
    private String folderPathImages;

    @GetMapping("/")
    public String mainPage(ModelMap modelMap){
        List<Sport> findAllSport = sportService.getEightSport();
        List<League> findAllLeague = leagueService.getUefaLeagues();
        List<News> findAllNews = newsService.getThreeNews();
        modelMap.addAttribute("sport", findAllSport);
        modelMap.addAttribute("league", findAllLeague);
        modelMap.addAttribute("news", findAllNews);
        return "index";
    }

    @GetMapping("/league/getImage")
    public @ResponseBody byte[] getImage(@RequestParam("fileImage") String fileName) throws IOException {
        InputStream inputStream = new FileInputStream(folderPathImages + File.separator + fileName);
        return IOUtils.toByteArray(inputStream);
    }
}
