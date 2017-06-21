package by.news.application;

import by.news.domain.News;
import by.news.persistance.repository.NewsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.ConcurrentLinkedQueue;

@Component
public class SaveRunner implements Runnable {

    private static final Logger LOGGER = LoggerFactory.getLogger(SaveRunner.class);

    private  ConcurrentLinkedQueue<News> linkedQueue;

    private  NewsRepository newsRepository;

    @Autowired
    public SaveRunner(ConcurrentLinkedQueue<News> linkedQueue, NewsRepository newsRepository) {
        this.linkedQueue = linkedQueue;
        this.newsRepository = newsRepository;
    }



    @Override
    public void run() {
        while (true) {
            try {
                if (!linkedQueue.isEmpty()) {
                    News news = linkedQueue.poll();
                    newsRepository.save(news);
                    LOGGER.info("saveNewsRepository() {} ", news);
                }
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                LOGGER.error("SaveRunnable run()", e);
            }
        }
    }
}
