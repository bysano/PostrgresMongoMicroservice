package by.user.domain;

import com.fasterxml.jackson.annotation.JsonValue;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public enum FilterOperator {
    IN("in") {
        public Predicate tranformTopredicate(FilterDTO filterDTO, CriteriaBuilder criteriaBuilder, Root<User> root) {
            Path exp = root.<User>get(filterDTO.getProperty());
            return exp.in(filterDTO.getValue());
        }
    },
    //    LIKE("like"),
//    GT("gt"),
//    LT("lt"),
    EQ("eq") {
        public Predicate tranformTopredicate(FilterDTO filterDTO, CriteriaBuilder criteriaBuilder, Root<User> root) {
            return criteriaBuilder.equal(root.get(filterDTO.getProperty()), filterDTO.getValue());
        }
    };

    public abstract Predicate tranformTopredicate(FilterDTO filterDTO, CriteriaBuilder criteriaBuilder, Root<User> root);

    FilterOperator(String value) {
        this.value = value;
    }

    private String value;

    @JsonValue
    public String getValue() {
        return value;
    }
}
