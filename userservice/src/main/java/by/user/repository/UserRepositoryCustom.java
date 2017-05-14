package by.user.repository;

import by.user.domain.User;

/**
 * Created by alka0317 on 4/21/2017.
 */
public interface UserRepositoryCustom {
    User getUserByQuery();
    User getUserBySurnameAndQuery(String surname);
}
