package rc.context.test;

import by.user.domain.Address;
import by.user.domain.User;
import by.user.service.UserService;
import org.junit.*;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;


import by.user.application.DemoApplication;

import java.util.ArrayList;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = DemoApplication.class)
public class ApplicationTest {
    @Autowired
    private UserService userService;



    private static final Logger logger = LoggerFactory.getLogger(ApplicationTest.class);

    private User testUser;
    private   List<Address> addresses;

    @Before
    public void setUp() {
        testUser = new User("test","test");
        addresses= new ArrayList();
        Address address = new Address("testCity","testStreet",testUser);
        addresses.add(address);
        testUser.setAddress(addresses);
        userService.addUser(testUser);
    }

    @Test
    public void contextLoads() {
    }

//    @Test
//    public void findNewsByTitleAndTags() {
//        List<News> newsList = newsService.findNewsbyTitleAndTags("random", "sports");
//        logger.info(newsList.toString());
//    }

    @Test
    public void getUsers() {
        logger.info(userService.getUserBySurname("kazlouski").toString());
        logger.info(userService.getUserbyCustomQuery("test").toString());
        List<User> userList = userService.getUsers();
        logger.info(userList.toString());
        Assert.assertTrue(userList != null);
    }

    @Test
    public void deleteUserByName() {
        userService.deleteUserByName(testUser.getName());
        Assert.assertTrue(userService.checkExistence(testUser));
    }

//    @Test
//    public void finNewsByTitle() {
//        List<News> newsList = newsService.findByTitle("test");
//        System.out.println(newsList.toString());
//    }

    @Test
    public void queryTest() {
        Assert.assertEquals(userService.getUserByQuery(), testUser);

    }

    @Test
    public void getUserBySurnameAndQuery() {
        Assert.assertEquals(userService.getUserBySurname(testUser.getSurname()), testUser);
    }

    @Test
    public void customQueryInInterfaceTest() {
        User user = userService.getUserbyCustomQuery(testUser.getName());
        logger.info(user.toString());
    }

    @After
    public void clean() {
        userService.deleteUser(testUser);
    }

}
