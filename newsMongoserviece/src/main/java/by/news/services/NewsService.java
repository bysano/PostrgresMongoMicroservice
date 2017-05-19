package by.news.services;

import by.news.domain.News;
import by.news.persistance.repository.NewsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsService {

    private static final Logger log = LoggerFactory.getLogger(NewsService.class);

    private NewsRepository newsRepository;

    @Autowired
    public NewsService(NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }

    public List<News> getNews() {
        List<News> newsList = newsRepository.findAll();
        return newsList;
    }

    public void saveNews(News news) {
        newsRepository.insert(news);
    }

    public List<News> findNewsbyTitleAndTags(String title, String tags){
        return newsRepository.findbyTitleAndTags(title,tags);
    }
    public List<News> findByTitle(String title) {
        List<News> newsList = newsRepository.getNewsByTitle(title);
        return newsList;
    }

}
