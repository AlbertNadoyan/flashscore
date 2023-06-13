package am.itspace.flashscore.service.impl;

import am.itspace.flashscore.model.News;
import am.itspace.flashscore.repository.NewsRepository;
import am.itspace.flashscore.service.NewsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NewsServiceImpl implements NewsService {
    private final NewsRepository newsRepository;
    @Override
    public List<News> getAllNews() {
        return newsRepository.findAll();
    }

    @Override
    public List<News> getAllNewsById(int id) {
        return newsRepository.findAllById(id);
    }

    @Override
    public List<News> getThreeNews() {
        return newsRepository.findTop3ByOrderById();
    }
}
