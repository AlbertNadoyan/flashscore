package am.itspace.flashscore.controller;

import am.itspace.flashscore.model.News;
import am.itspace.flashscore.service.NewsService;
import am.itspace.flashscore.service.SportService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
public class NewsController {

    @Value("${flashscore.spring.images.folder}")
    private String folderPathImages;
    private final NewsService newsService;
    private final SportService sportService;

    @GetMapping("/news")
    public String newsPage(ModelMap modelMap){
        List<News> findAllNews = newsService.getAllNews();
        modelMap.addAttribute("news", findAllNews);
        return "news";
    }

    @GetMapping("/news/{id}")
    public String currentNews(@PathVariable("id") int id, ModelMap modelMap){
        List<News> findCurrentNews = newsService.getAllNewsById(id);
        modelMap.addAttribute("currentNews", findCurrentNews);
        return "currentNews";
    }

    @GetMapping("/news/getImage")
    public @ResponseBody byte[] getImage(@RequestParam("fileImage") String fileName) throws IOException {
        InputStream inputStream = new FileInputStream(folderPathImages + File.separator + fileName);
        return IOUtils.toByteArray(inputStream);
    }
}
