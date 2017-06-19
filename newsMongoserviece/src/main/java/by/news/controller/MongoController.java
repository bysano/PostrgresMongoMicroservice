package by.news.controller;

import by.news.client.UserClient;
import by.news.domain.News;
import by.news.domain.User;
import by.news.services.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@RestController
@RequestMapping(path = "/api", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class MongoController {

    private RestTemplate restTemplate;
    private NewsService newsService;
    private UserClient userClient;

    @Autowired
    public MongoController(RestTemplate restTemplate, NewsService newsService, UserClient userClient) {
        this.restTemplate = restTemplate;
        this.newsService = newsService;
        this.userClient = userClient;
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
    public HttpStatus saveNews(@RequestBody News news) {
        newsService.saveNews(news);
        return HttpStatus.OK;
    }

    @GetMapping("/users")
    public List<User> getUsers() {

        return userClient.getUsers();
    }
}
