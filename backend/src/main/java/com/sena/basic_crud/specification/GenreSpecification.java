package com.sena.basic_crud.specification;

import com.sena.basic_crud.model.Genre;
import org.springframework.data.jpa.domain.Specification;

public class GenreSpecification {
    public static Specification<Genre> hasName(String name) {
        return (root, query, criteriaBuilder) ->
                name == null ? criteriaBuilder.conjunction() :
                        criteriaBuilder.like(criteriaBuilder.lower(root.get("name")), "%" + name.toLowerCase() + "%");
    }
}
