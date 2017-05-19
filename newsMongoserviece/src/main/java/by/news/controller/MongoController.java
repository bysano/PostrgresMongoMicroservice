package by.news.controller;

import by.news.domain.News;
import by.news.services.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class MongoController {

    private NewsService newsService;

    @Autowired
    public MongoController(NewsService newsService) {
        this.newsService = newsService;
    }

    @GetMapping("/info")
    public String info() {
        return "hello";
    }

    @GetMapping("/news")
    public List<News> getNews() {
        List<News> news = newsService.getNews();
        return news;
    }

    @PostMapping("/save")
    public HttpStatus saveNews(@RequestBody News news){
        newsService.saveNews(news);
        return HttpStatus.OK;
    }
}
