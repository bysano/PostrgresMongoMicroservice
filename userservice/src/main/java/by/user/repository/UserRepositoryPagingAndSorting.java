package by.user.repository;

import by.user.domain.User;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserRepositoryPagingAndSorting extends PagingAndSortingRepository<User, Long>,JpaSpecificationExecutor<User> {

}
