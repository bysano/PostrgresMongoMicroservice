package by.news.application;

import by.news.domain.News;
import by.news.persistance.repository.NewsRepository;
import by.news.services.NewsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class DatabaseSetter implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(NewsService.class);
    @Autowired
    private NewsRepository newsRepository;

    @Override
    public void run(String... strings) throws Exception {
        List<News> newsList = new ArrayList<>();
        newsList.add(new News("Inserted Tittle", "inserted subject", "inserted"));
        newsList.add(new News("Random Tittle", "Random subject", "Random"));
        newsList.add(new News("Tittle", "subject", "tags"));
        newsRepository.deleteAll();
        log.info("### > Inserting Data...");
        newsRepository.save(newsList);
        log.info("> Done.");
    }
}
