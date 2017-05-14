package by.news.persistance.repository;

import by.news.domain.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;


@Transactional(readOnly = true)
@Repository
public class NewsRepositoryImpl implements NewsRepositoryCustom {

    @Autowired
    private MongoTemplate mongoTemplate;

    private static final String NEWS_FIELD_TITLE ="title";

    @Override
    public List<News> getNewsByTitle(String title) {
        Query query = new Query();
        query.addCriteria(Criteria.where(NEWS_FIELD_TITLE).is(title));
        List<News> newsList = mongoTemplate.find(query, News.class);
        return newsList;
    }


}
