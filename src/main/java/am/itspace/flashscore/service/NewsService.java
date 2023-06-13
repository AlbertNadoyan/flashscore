package am.itspace.flashscore.service;

import am.itspace.flashscore.model.News;

import java.util.List;

public interface NewsService {
    List<News> getAllNews();
    List<News> getAllNewsById(int id);

    List<News> getThreeNews();
}
