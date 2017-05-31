package by.news.client;

import by.news.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class UserClient {

    private Logger LOG = LoggerFactory.getLogger(UserClient.class);

    private final String GET_USERS_URI = "/users/";

    @Value("${userservice.url}")
    private String userServiceUrl;

    private RestTemplate restTemplate;

    @Autowired
    public UserClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<User> getUsers() {
        List<User> users = null;
        try {
            String url = userServiceUrl + GET_USERS_URI;
            LOG.info("Requested url: {} ",url);
            ResponseEntity<List<User>> responseServiceTemplates =
                    restTemplate.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<List<User>>() {
                    });
            LOG.info("Received Response entity:{}",responseServiceTemplates);
            users = responseServiceTemplates.getBody();
        } catch (HttpClientErrorException e) {
            LOG.warn("Exception during executing {} request on userservice {}",GET_USERS_URI,e);
        }
        return users;
    }
}
