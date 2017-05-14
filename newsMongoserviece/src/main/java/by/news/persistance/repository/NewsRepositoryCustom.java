package by.news.persistance.repository;



import by.news.domain.News;

import java.util.List;

/**
 * Created by alka0317 on 4/21/2017.
 */

public interface NewsRepositoryCustom {
    List<News> getNewsByTitle(String title);

}
