package by.news.persistance.repository;



import by.news.domain.News;

import java.util.List;


public interface NewsRepositoryCustom {
    List<News> getNewsByTitle(String title);

}
