package by.news.persistance.repository;


import by.news.domain.News;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface NewsRepository extends MongoRepository<News, String>, NewsRepositoryCustom {
    List<News> findByTitle(String title);

    default List<News> findbyTitleAndTags(String title, String tags) {
        List<News> list = findByTitle(title);
        list.stream().filter(s -> s.getTags().contains(tags));
        return list;
    }

}
