package com.sena.basic_crud.specification;

import com.sena.basic_crud.model.SubscriptionPlan;
import org.springframework.data.jpa.domain.Specification;

public class SubscriptionPlanSpecification {
    public static Specification<SubscriptionPlan> hasName(String name) {
        return (root, query, criteriaBuilder) ->
                name == null ? criteriaBuilder.conjunction() :
                        criteriaBuilder.like(criteriaBuilder.lower(root.get("name")), "%" + name.toLowerCase() + "%");
    }

    public static Specification<SubscriptionPlan> hasType(String type) {
        return (root, query, criteriaBuilder) ->
                type == null ? criteriaBuilder.conjunction() :
                        criteriaBuilder.equal(criteriaBuilder.lower(root.get("type")), type.toLowerCase());
    }
}
