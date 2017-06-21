package by.news;

import by.news.application.SaveRunner;
import by.news.domain.News;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.ConcurrentLinkedQueue;

@SpringBootApplication
@EnableDiscoveryClient
public class Application {
    public static void main(String[] args) {
        ConfigurableApplicationContext run=SpringApplication.run(Application.class, args);
        Thread saveThread = new Thread(run.getBean(SaveRunner.class));
        saveThread.start();
    }

    @Bean
    public ConcurrentLinkedQueue<News> newsqueue(){
        return new ConcurrentLinkedQueue<>();
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
