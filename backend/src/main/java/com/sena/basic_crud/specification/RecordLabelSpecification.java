package com.sena.basic_crud.specification;

import com.sena.basic_crud.model.RecordLabel;
import org.springframework.data.jpa.domain.Specification;

public class RecordLabelSpecification {
    public static Specification<RecordLabel> hasName(String name) {
        return (root, query, criteriaBuilder) ->
                name == null ? criteriaBuilder.conjunction() :
                        criteriaBuilder.like(criteriaBuilder.lower(root.get("name")), "%" + name.toLowerCase() + "%");
    }

    public static Specification<RecordLabel> hasCountry(String country) {
        return (root, query, criteriaBuilder) ->
                country == null ? criteriaBuilder.conjunction() :
                        criteriaBuilder.equal(criteriaBuilder.lower(root.get("country")), country.toLowerCase());
    }
}
