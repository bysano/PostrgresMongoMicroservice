package by.news.tests;

import by.news.domain.News;
import by.news.persistance.repository.NewsRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RunWith(SpringRunner.class)
@SpringBootTest
public class NewsServiceTest {

    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(NewsServiceTest.class);

    @Autowired
    private NewsRepository newsRepository;

    @Test
    public void contextLoads() {
    }

    @Test
    public void lamdaTest() {
        List<News> newsList = newsRepository.findbyTitleAndTags("tags");
        List<News> test = new ArrayList<>();
        LOGGER.info(newsList.toString());
        List<String> strings=newsRepository.findAll().stream().map(n -> n.getTags().toUpperCase()).collect(Collectors.toList());
        List<News> newsList1 = newsRepository.findAll();
        newsList.stream().peek(n -> n.getTags().toUpperCase()).collect(Collectors.toList());
        LOGGER.info(newsRepository.findAll().stream().map(n -> n.getTags().toUpperCase()).collect(Collectors.toList()).toString());
        newsList1.stream().forEach(n -> n.setTags(n.getTags().toUpperCase()));
        LOGGER.info(newsList1.toString());
        LOGGER.info(newsList1.stream().peek(n -> n.setTags(n.getTags().toUpperCase())).collect(Collectors.toList()).toString());


    }




}
