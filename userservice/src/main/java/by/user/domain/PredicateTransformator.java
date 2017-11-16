package by.user.domain;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public interface PredicateTransformator {
    Predicate tranformTopredicate(FilterDTO filterDTO, CriteriaBuilder criteriaBuilder, Root<User> root);
}
