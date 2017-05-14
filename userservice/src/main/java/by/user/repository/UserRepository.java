package by.user.repository;


import by.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;



@Repository
@Transactional
public interface UserRepository extends JpaRepository<User, Long>,UserRepositoryCustom {

    long deleteUserByName(String name);

    User findUserByName(String name);

    @Query("select j from User j where j.name=?1")
//    @Query(value = "select FROM USERS  where u.name=?1",nativeQuery = true)
    User customInterfaceQuery(String name);
}
