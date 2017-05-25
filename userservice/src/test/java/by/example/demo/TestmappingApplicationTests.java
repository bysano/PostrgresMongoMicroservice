package by.example.demo;

import by.TestmappingApplication;
import by.user.domain.Address;
import by.user.domain.User;
import by.user.repository.AddressRepository;
import by.user.repository.UserRepository;
import by.user.service.UserService;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.orm.jpa.JpaObjectRetrievalFailureException;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class  TestmappingApplicationTests {
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;
    @Autowired
    private AddressRepository addressRepository;

    private static final Logger logger = LoggerFactory.getLogger(TestmappingApplication.class);

    private User testUser;
    private List<Address> addresses;

    @Before
    public void setUp() {

        testUser = new User("SpringBootTestName", "SpringBootTestTestSurname");
        Address address = new Address("SpringBootTestTestCity", "SpringBootTest test street", testUser);
        addresses = new ArrayList();
        addresses.add(address);
        testUser.setAddress(addresses);

        userRepository.save(testUser);
        addressRepository.save(testUser.getAddress());

    }

//    @Test
//    public void findNewsByTitleAndTags() {
//        List<News> newsList = newsService.findNewsbyTitleAndTags("random", "sports");
//        logger.info(newsList.toString());
//    }

//    @Test
//    public void getUsers() {
//        logger.info(userService.getUserBySurname("kazlouski").toString());
//        logger.info(userService.getUserbyCustomQuery("test").toString());
//        List<User> userList = userService.getUsers();
//        logger.info(userList.toString());
//        Assert.assertTrue(userList != null);
//    }

    @Test
    public void deleteUserByName() {
        userService.deleteUserByName(testUser.getName());
        Assert.assertFalse(userService.checkExistence(testUser));
    }


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
        try {
            addressRepository.delete(addresses);
            userService.deleteUser(testUser);
        }catch (JpaObjectRetrievalFailureException e){
            logger.info("Unable to delete "+testUser);
        }

    }

    @Test
    public void contextLoads() {
    }

    @Test
    public void fetch() {
      Account account=accountRepository.findByCurrency("testaccount");
    }
}
