package by.news.services;

import by.news.domain.News;
import by.news.persistance.repository.NewsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

@Service
public class NewsService {

    private static final Logger log = LoggerFactory.getLogger(NewsService.class);

    private NewsRepository newsRepository;
    private ConcurrentLinkedQueue<News> linkedQueue;

    @Autowired
    public NewsService(NewsRepository newsRepository, ConcurrentLinkedQueue<News> linkedQueue) {
        this.newsRepository = newsRepository;
        this.linkedQueue = linkedQueue;
    }

    public List<News> getNews() {
        List<News> newsList = newsRepository.findAll();
        return newsList;
    }

    public void saveNews(News news) {
        log.info("added in queue - {}",news);
        linkedQueue.add(news);
    }

    public List<News> findNewsbyTitleAndTags(String tags){
        return newsRepository.findbyTitleAndTags(tags);
    }
    public List<News> findByTitle(String title) {
        List<News> newsList = newsRepository.getNewsByTitle(title);
        return newsList;
    }

}
