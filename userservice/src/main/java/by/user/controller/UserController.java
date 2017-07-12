package by.user.controller;

import by.user.domain.FilterDTO;
import by.user.domain.User;
import by.user.repository.UserRepositoryPagingAndSorting;
import by.user.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.criteria.Predicate;
import java.util.Arrays;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserRepositoryPagingAndSorting repositoryPagingAndSorting;

    @GetMapping("/get")
    public List<User> get() {
        return userService.getUsers();
    }

    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    @GetMapping("/filter")
    public Page<User> getFilt(
            @RequestParam(value = "limit", required = false, defaultValue = "10") Integer limit,
            @RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
            @RequestParam(value = "filter", required = false) FilterDTO[] filters) {
        List<FilterDTO> filterDTOS =Arrays.asList(filters);
        log.info("filter={}",filterDTOS);
        PageRequest pageRequest = new PageRequest((page - 1), limit, new Sort(Sort.Direction.ASC, "name"));
        Specification<User> specification = (root, criteriaQuery, criteriaBuilder) ->
                   criteriaBuilder.and(criteriaBuilder.equal(root.get(filterDTOS.get(0).getProperty()),filterDTOS.get(0).getValue()));
        Page<User> users = repositoryPagingAndSorting.findAll(specification, pageRequest);
        return users;
    }


    @GetMapping("/users")
    public Page<User> getUsers() {
        int page = 1;
        int limit = 10;
        PageRequest pageRequest = new PageRequest((page - 1), limit, new Sort(Sort.Direction.ASC, "name"));
        Specification<User> specification = (root, criteriaQuery, criteriaBuilder) -> {
            Predicate[] predicates = new Predicate[2];
            predicates[0] = criteriaBuilder.equal(root.get("name"), "TestUser");
            predicates[1] = criteriaBuilder.equal(root.get("surname"), "TestSurname");
            return criteriaBuilder.and(predicates);
        };

        Page<User> users = repositoryPagingAndSorting.findAll(specification, pageRequest);
        return users;
    }

    @GetMapping("/info")
    public String info() {
        return null;
    }

    @GetMapping("/save")
    public void save() {
        User testUser = new User("test", "test");
        userService.addUser(testUser);
    }
//
//    @GetMapping("/test")
//    public void delete() {
//        User newtestUser = new User("xxxxx", "yyyy");
//        userService.addUser(newtestUser);
//        userService.deleteUserByName("xxxxx");
//    }
}
