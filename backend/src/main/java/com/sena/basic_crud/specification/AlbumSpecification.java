package com.sena.basic_crud.specification;

import com.sena.basic_crud.model.Album;
import org.springframework.data.jpa.domain.Specification;

public class AlbumSpecification {
    public static Specification<Album> hasName(String name) {
        return (root, query, criteriaBuilder) ->
                name == null ? criteriaBuilder.conjunction() :
                        criteriaBuilder.like(criteriaBuilder.lower(root.get("title")), "%" + name.toLowerCase() + "%");
    }

    public static Specification<Album> hasType(String type) {
        return (root, query, criteriaBuilder) ->
                type == null ? criteriaBuilder.conjunction() :
                        criteriaBuilder.equal(criteriaBuilder.lower(root.get("type")), type);
    }
}
