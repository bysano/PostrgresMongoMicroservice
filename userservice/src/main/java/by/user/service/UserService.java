package by.user.service;

import by.user.domain.User;
import by.user.repository.AddressRepository;
import by.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AddressRepository addressRepository;

    public List<User> getUsers() {
        List<User> users = this.userRepository.findAll();
        return users;
    }

    public User getUserbyCustomQuery(String name) {

        return userRepository.customInterfaceQuery(name);
    }

    public void addUser(User user) {
        this.userRepository.save(user);
        this.addressRepository.save(user.getAddress());
    }

    public boolean checkExistence(User user) {
        if (userRepository.findUserByName(user.getName()) != null)
            return false;
        else
            return true;
    }

    public void deleteUser(User user) {

        this.userRepository.delete(user);


    }

    public void deleteUserByName(String name) {
        this.userRepository.deleteUserByName(name);
    }

    public User getUserByQuery() {
        return userRepository.getUserByQuery();
    }


    public User getUserBySurname(String surname) {
        return userRepository.getUserBySurnameAndQuery(surname);
    }
}
