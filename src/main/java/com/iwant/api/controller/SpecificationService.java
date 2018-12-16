package com.iwant.api.controller;

import com.iwant.api.model.WantActivity;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.math.BigDecimal;

@Service
public class SpecificationService {

    public Specification<WantActivity> isNotEqual(String param, int value) {
        return new Specification<WantActivity>() {
            public javax.persistence.criteria.Predicate toPredicate(Root<WantActivity> root, CriteriaQuery<?> query,
                                                                    CriteriaBuilder builder) {
                return builder.notEqual(root.get(param), value);
            }
        };
    }

    public Specification<WantActivity> isIntEqual(String param, int value) {
        return new Specification<WantActivity>() {
            public javax.persistence.criteria.Predicate toPredicate(Root<WantActivity> root, CriteriaQuery<?> query,
                                                                    CriteriaBuilder builder) {
                return builder.equal(root.get(param), value);
            }
        };
    }

    public Specification<WantActivity> isBigDecimalEqual(String param, BigDecimal price) {
        return new Specification<WantActivity>() {
            public javax.persistence.criteria.Predicate toPredicate(Root<WantActivity> root, CriteriaQuery<?> query,
                                                                    CriteriaBuilder builder) {
                return builder.equal(root.get(param), price);
            }
        };
    }

    public Specification<WantActivity> isBetweenTime(String param, long fromTime, long toTime) {
        return new Specification<WantActivity>() {
            public javax.persistence.criteria.Predicate toPredicate(Root<WantActivity> root, CriteriaQuery<?> query,
                                                                    CriteriaBuilder builder) {
                return builder.between(root.get(param), fromTime, toTime);
            }
        };
    }

    public Specification<WantActivity> isEqual(String param, String country) {
        return new Specification<WantActivity>() {
            public javax.persistence.criteria.Predicate toPredicate(Root<WantActivity> root, CriteriaQuery<?> query,
                                                                    CriteriaBuilder builder) {
                return builder.equal(root.get(param), country);
            }
        };
    }
}