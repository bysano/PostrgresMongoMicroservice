package by.news.persistance.repository;

import com.mongodb.CommandResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

/**
 * Created by alka0317 on 5/29/2017.
 */
@Component
public class MongoHealthIndicator extends AbstractHealthIndicator {

    private final MongoTemplate mongoTemplate;

    @Autowired
    public MongoHealthIndicator(MongoTemplate mongoTemplate) {
        Assert.notNull(mongoTemplate, "MongoTemplate must not be null");
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    protected void doHealthCheck(Health.Builder builder) throws Exception {
        CommandResult result = this.mongoTemplate.executeCommand("{ buildInfo: 1 }");
        builder.up().withDetail("version", result.getString("version"));
    }
}
