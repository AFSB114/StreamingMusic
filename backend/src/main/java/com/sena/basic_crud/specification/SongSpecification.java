package com.sena.basic_crud.specification;

import com.sena.basic_crud.model.Song;
import org.springframework.data.jpa.domain.Specification;

public class SongSpecification {
    public static Specification<Song> hasName(String name) {
        return (root, query, criteriaBuilder) ->
                name == null ? criteriaBuilder.conjunction() :
                        criteriaBuilder.like(criteriaBuilder.lower(root.get("title")), "%" + name.toLowerCase() + "%");
    }

    public static Specification<Song> hasGenreId(Integer genreId) {
        return (root, query, criteriaBuilder) ->
                genreId == null ? criteriaBuilder.conjunction() :
                        criteriaBuilder.equal(root.get("genreId").get("id"), genreId);
    }

}
