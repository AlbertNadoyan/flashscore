package am.itspace.flashscore.service.impl;

import am.itspace.flashscore.model.TeamPlayerInfo;
import am.itspace.flashscore.repository.TeamPlayerInfoRepository;
import am.itspace.flashscore.service.ScraperService;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.RequiredArgsConstructor;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
@RequiredArgsConstructor
public class ScraperServiceImpl implements ScraperService {

    private final TeamPlayerInfoRepository teamPlayerInfoRepository;

    @Value("${website.urls}")
    private String urlPath;

    private static Map<String, String> teamPlayerInfo = new HashMap<>();

    @Override
    public void extractDataFromWebSite() {
        List<String> names = new ArrayList<>();
        List<String> images = new ArrayList<>();

        try {
            Document document = Jsoup.connect(urlPath).get();
            Elements childElements = document.select(".table-responsive .limittext");
            Elements parentElementImage = document.select(".logo-md");

            childElements.forEach(element -> names.add(element.text()));
            parentElementImage.forEach(element -> images.add(element.attr("style").substring(22, element.attr("style").length() - 2)));

            if (names.size() == images.size()) {
                teamPlayerInfo = IntStream.range(0, names.size())
                        .boxed()
                        .collect(Collectors.toMap(names::get, i -> {
                            String modifiedImage = urlPath.substring(0, urlPath.length() - 14) + images.get(i);
                            return modifiedImage;
                        }));
            } else {
                System.out.println("Error: Number of names and images do not match.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        saveDataToDatabase(teamPlayerInfo);
    }

    public void saveDataToDatabase(Map<String, String> teamPlayerInfo) {
        for (Map.Entry<String, String> stringStringEntry : teamPlayerInfo.entrySet()) {
            TeamPlayerInfo teamPlayerInfoSave = new TeamPlayerInfo();
            teamPlayerInfoSave.setName(stringStringEntry.getKey());
            teamPlayerInfoSave.setImage(stringStringEntry.getValue());
            teamPlayerInfoRepository.save(teamPlayerInfoSave);
        }

        System.out.println("Data saved to the database successfully.");
    }

}

