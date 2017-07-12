package by.user.application;

import by.user.domain.Address;
import by.user.domain.User;
import by.user.repository.AddressRepository;
import by.user.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alka0317 on 5/11/2017.
 */
@Component
public class DataSeter implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(DataSeter.class);
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AddressRepository addressRepository;

    @Override
    public void run(String... strings) throws Exception {
//
//        addressRepository.deleteAll();
//        userRepository.deleteAll();
//        User user = new User("TestUser", "TestSurname");
//        Address address = new Address("TestCity", "test street", user);
//        List<Address> addresses = new ArrayList();
//        addresses.add(address);
//        user.setAddress(addresses);
//
//        userRepository.save(user);
//        addressRepository.save(user.getAddress());
//
//        User user1 = new User("aliaksandr", "Kazlouski");
//        Address address1 = new Address("Minsk", "Skorini", user1);
//        List<Address> addresses1 = new ArrayList();
//        addresses1.add(address1);
//        user1.setAddress(addresses1);
//
//        log.info("### > Inserting Data...");
//        userRepository.save(user1);
//        addressRepository.save(user1.getAddress());
//        log.info("> Done.");

    }
}
