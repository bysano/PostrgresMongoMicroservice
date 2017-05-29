package by.news.persistance.repository;

import by.news.domain.News;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public interface NewsRepository extends MongoRepository<News, String>, NewsRepositoryCustom {
    List<News> findByTitle(String title);

    default List<News> findbyTitleAndTags(String tags) {
        List<News> list = findAll();
        return list.stream().filter(s -> s.getTags().contains(tags)).collect(Collectors.toList());
    }

}
