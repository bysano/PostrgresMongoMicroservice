package by.user.repository;


import by.user.domain.User;
import by.user.domain.User_;
import org.springframework.stereotype.Repository;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;


@Repository
public class UserRepositoryImpl implements UserRepositoryCustom {


    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public User getUserByQuery() {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> userCriteriaQuery = builder.createQuery(User.class);
        Root<User> root = userCriteriaQuery.from(User.class);
        userCriteriaQuery.select(root).where(builder.equal(root.get(User_.name), "test"));
        TypedQuery<User> typedQuery = entityManager.createQuery(userCriteriaQuery);
        User mnewUserList = typedQuery.getSingleResult();
        return mnewUserList;
    }

    public User getUserBySurnameAndQuery(String surname) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> userCriteriaQuery = builder.createQuery(User.class);
        Root<User> root = userCriteriaQuery.from(User.class);
        userCriteriaQuery.select(root).where(builder.equal(root.get(User_.surname), surname));
        TypedQuery<User> typedQuery = entityManager.createQuery(userCriteriaQuery);
        User mnewUserList = typedQuery.getSingleResult();
        return mnewUserList;
    }
}
